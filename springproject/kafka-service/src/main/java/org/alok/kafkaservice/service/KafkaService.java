package org.alok.kafkaservice.service;

import org.alok.kafkaservice.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public  boolean updateLocation(String location){
        kafkaTemplate.send(AppConstant.TOPIC_NAME, location);
        return true;
    }


}
