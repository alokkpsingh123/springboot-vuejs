BASE_DIR=~/solr_primer_session
 
SOLR=solr-8.11.2

SOLR_DOWNLOAD_URL=https://dlcdn.apache.org/lucene/solr/8.11.2/solr-8.11.2.tgz

SOLR_DOWNLOAD_LOC=/tmp/$SOLR.tgz
 
ZOOKEEPER=apache-zookeeper-3.6.2-bin

ZOO_DOWNLOAD_URL=https://archive.apache.org/dist/zookeeper/zookeeper-3.6.2/apache-zookeeper-3.6.2-bin.tar.gz

ZOO_DOWNLOAD_LOC=/tmp/$ZOOKEEPER.tar.gz
 
ZOOKEEPER_HOME=$BASE_DIR/$ZOOKEEPER

SOLR_HOME=$BASE_DIR/$SOLR
 
cleanup() {

    rm -rf $BASE_DIR

    lsof -i :2181 -t | xargs -I{} kill -9 {}

    lsof -i :8983 -t | xargs -I{} kill -9 {}

    lsof -i :8080 -t | xargs -I{} kill -9 {}

}
 
exit_on_error() {

    local ret=$1

    local msg=$2

    if [ $ret -ne 0 ]; then

        echo "Failed: $msg \n"

        exit 1

    fi

}
 
check_java() {

    command -v java &> /dev/null

    exit_on_error $? "Java not installed. Please install Java from https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_osx-x64_bin.tar.gz"

    java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')

    echo "Java version: $java_version"

}
 
create_base_dir() {

    mkdir -p $BASE_DIR

    if [ $? -eq 0 ]; then

        echo "\nSolr session base directory created. Location=$BASE_DIR\n"

        cd $BASE_DIR

    else

        echo "\nSolr session base directory creation failed. Location=$BASE_DIR\n"

    fi

}
 
download() {

    local type=$1

    local url=$2

    local dest=$3

    echo "Downloading $type. Please wait...\n"

    curl -# $url -o $dest

    exit_on_error $? "Downloading $type failed."

}
 
extract() {

    local type=$1

    local archive_loc=$2

    echo "Extracting $type. Please wait...\n"

    tar -xzf $archive_loc

    exit_on_error $? "Extraction of $type failed."

}
 
update_zookeeper_conf() {

    echo "Updating zookeeper conf..."

    search_txt="/tmp/zookeeper"

    replace_txt="$ZOOKEEPER_HOME/data"

    cp $ZOOKEEPER_HOME/conf/zoo_sample.cfg $ZOOKEEPER_HOME/conf/zoo.cfg

    sed -i "" "s|$search_txt|$replace_txt|" "$ZOOKEEPER_HOME/conf/zoo.cfg"

    echo "4lw.commands.whitelist=mntr,conf,ruok" >> "$ZOOKEEPER_HOME/conf/zoo.cfg"

}
 
start_zookeeper() {

    pushd $ZOOKEEPER_HOME > /dev/null

    echo "Starting zookeeper..."

    ./bin/zkServer.sh start

    popd > /dev/null

}
 
update_solr_conf() {

    pushd $SOLR_HOME

    echo "Updating solr conf..."

    cp -r server/solr server/solr_instance1

    cp -r server/solr server/solr_instance2

    cp -r server/solr server/solr_instance3

    curl -# https://artifactory.gdn-app.com/artifactory/libs-releases-local/com/gdn/x/search/solrplugin/solr-plugin/8.19.0-7/solr-plugin-8.19.0-7-jar-with-dependencies.jar -o /tmp/solr-plugin-8.19.0-7-jar-with-dependencies.jar

    mkdir -p contrib/plugin/

    cp /tmp/solr-plugin-8.19.0-7-jar-with-dependencies.jar contrib/plugin/

    popd

}
 
start_solr() {

    pushd $SOLR_HOME > /dev/null

    echo "Starting solr..."

    ./bin/solr -c -p 8983 -z localhost:2181 -s server/solr_instance1

    popd > /dev/null

}
 
setup_data1() {

    pushd $SOLR_HOME > /dev/null

    bin/solr zk upconfig -n techProductConfig -z localhost:2181 -d server/solr_instance1/configsets/sample_techproducts_configs/conf/

    curl -s "http://localhost:8983/solr/admin/collections?action=CREATE&name=tech_products&numShards=2&replicationFactor=2&maxShardsPerNode=4&collection.configName=techProductConfig"

    bin/post -c tech_products example/exampledocs/* > /dev/null

    popd > /dev/null

}
 
setup_data2() {

    pushd $SOLR_HOME > /dev/null

    bin/solr create -c films > /dev/null

    curl -s http://localhost:8983/solr/films/schema -X POST -H 'Content-type:application/json' --data-binary '{

    "add-field" : {

    "name":"name",

    "type":"text_general",

    "multiValued":false,

    "stored":true

},

"add-field" : {

"name":"initial_release_date",

"type":"pdate",

"stored":true

}

}'

    bin/post -c films example/films/films.json > /dev/null

    popd > /dev/null

}
 
setup_qa2_data() {

    solr zk downconfig -n retailCollection -d /tmp/retailConf -z x-search-zk-1.qa2-sg.cld:2181

solr zk upconfig -n retailCollectionConfig -d /tmp/retailConf -z localhost:2181

}
 
setpath() {

    echo "Setting up path..."

    echo "export solr_home=$SOLR_HOME" >> $BASE_DIR/.solr_bashrc

    echo "export zoo_home=$ZOOKEEPER_HOME" >> $BASE_DIR/.solr_bashrc

    echo "export PATH=$PATH:$SOLR_HOME/bin:$ZOOKEEPER_HOME/bin" >> $BASE_DIR/.solr_bashrc

    echo "alias cds='cd $SOLR_HOME'" >> $BASE_DIR/.solr_bashrc

    echo "alias cdz='cd $ZOOKEEPER_HOME'" >> $BASE_DIR/.solr_bashrc

    source $BASE_DIR/.solr_bashrc

}
 
end() {

    echo "\nHappy searching!\n"

    echo "Location: $BASE_DIR"

    open http://localhost:8983

}
 
 
echo "Starting solr setup. please hold on...\n"

check_java

cleanup

create_base_dir

download "solr" $SOLR_DOWNLOAD_URL $SOLR_DOWNLOAD_LOC

extract "solr" $SOLR_DOWNLOAD_LOC

download "zookeeper" $ZOO_DOWNLOAD_URL $ZOO_DOWNLOAD_LOC

extract "zookeeper" $ZOO_DOWNLOAD_LOC

update_zookeeper_conf

start_zookeeper

update_solr_conf

start_solr

setup_data1

setup_data2

setpath

setup_qa2_data

end
