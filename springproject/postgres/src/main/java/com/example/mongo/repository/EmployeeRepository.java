package com.example.mongo.repository;

import com.example.mongo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.bankAccount b"+ " WHERE e.employeeId = ?1")
    Optional<Employee> findEagerByEmployeeIds(String employeeId);

    @Query("SELECT e FROM Employee e")
    Optional<Employee> findAllEmployee();
//
//    @Query("UPDATE EMPLOYEE SET firstName = ?1 WHERE employeeId = ?2")
//    Optional<Employee> updateByEmpId(String fname, String employeeId);

}