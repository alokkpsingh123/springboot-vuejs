package com.example.mongo.repository.impl;

import com.example.mongo.dto.EmployeeCountResponse;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.EmployeeCustomRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.security.UnresolvedPermission;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Employee> findAllUsingTemplate(String firstName) {
        Query query = new Query();
        query.addCriteria(where("firstName").is(firstName));
        return mongoTemplate.find(query, Employee.class);
    }

    @Override
    public List<Employee> isActive() {
        Query query = new Query();
        query.addCriteria(where("isActive").is(Boolean.TRUE));
        return mongoTemplate.find(query, Employee.class);
    }

    @Override
    public Employee findOneEmployee(String lastName) {
        Query query = new Query();
        query.addCriteria(where("lastName").is(lastName));
        return mongoTemplate.findOne(query, Employee.class);
    }

    @Override
    public List<Employee> displayOnlyFirsName() {
        Query query = new Query();
        query.fields().exclude("lastName", "dob","dbj", "isActive").include("firstName");
        return mongoTemplate.find(query,Employee.class);
    }

    @Override
    public UpdateResult updateDepartmentById(String employeeID) {

        Query query = Query.query(where("employeeId").is(employeeID));
        Update update = Update.update("department" , "HR");

        return mongoTemplate.updateMulti(query, update, Employee.class);

    }

    @Override
    public List<EmployeeCountResponse> countInEachDepartment() {

        /**
         *
         * dp.employee.aggregate([{
         *     {
         *       $group: {
         *           "_id": "department",
         *           count : { $sum: 1}
         *       }
         *     },
         *     {
         *       $project:{
         *          department : "$_id"
         *          count : 1
         *       }
         *     },
         *     {
         *         $match: { age: { $gt: 25, $lt: 30 } }
         *     }
         * }])
         **/


        GroupOperation groupByDepartment = group("department")
                .count().as("employeeCountInDepartment");
        SortOperation sortByDepartment = sort(Sort.by(Sort.Direction.DESC, "department"));
        ProjectionOperation projectionOperation = project().and("_id").as("department").and("employeeCountInDepartment").as("count");
        Aggregation aggregation = newAggregation( groupByDepartment, sortByDepartment, projectionOperation);

        return mongoTemplate.aggregate(
                aggregation, Employee.class, EmployeeCountResponse.class).getMappedResults();


    }

    @Override
    public List<EmployeeCountResponse> countInEachDepartmentByAge() {

        GroupOperation groupByDepartment = group("department")
                .count().as("employeeCountInDepartment");
        Criteria criteria = Criteria.where("age").lt(30).gt(25);
        MatchOperation filter = match(new Criteria().andOperator(where("age").lt(30), where("age").gt(25)));

        SortOperation sortByDepartment = sort(Sort.by(Sort.Direction.DESC, "department"));

        ProjectionOperation projectionOperation = project().and("_id").as("department").and("employeeCountInDepartment").as("count");

        Aggregation aggregation = newAggregation(  filter,groupByDepartment, sortByDepartment, projectionOperation);
        return mongoTemplate.aggregate(
                aggregation, Employee.class, EmployeeCountResponse.class).getMappedResults();

    }

}
