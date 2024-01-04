package com.example.mongo.repository;

import com.example.mongo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByFirstNameAndLastName (String firstName , String lastName);

    List<Employee> findByFirstName(String firstName);

    @Query("{firstName : ?0}") // specify that this is a query and it translates the query according to parameters
    List<Employee> fetchEmployeeByFirstName(String firstName);


//    @Query(value = "{firstName : ?0}", sort = "{dateOfBirth : 1}")
//    List<Employee> fetchEmployee


}
