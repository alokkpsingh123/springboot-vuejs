package com.example.mongo.repository;

import com.example.mongo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("{firstName : ?0}")
    List<Employee> fetchEmployeesByFistName(String name);

    @Query(value = "{ firstName : ?0}", sort = "{dateOfBirth:1}")
    List<Employee> fetchEmployeesByFirstNameSortByDob(String name);


}