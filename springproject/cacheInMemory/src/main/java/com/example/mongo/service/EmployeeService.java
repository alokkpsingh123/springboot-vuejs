package com.example.mongo.service;

import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployees();

    void clearAll();

    boolean editEmployee(EmployeeDto employeeDto, String employeeId);

    Employee getByEmployeeId(String employeeId);

    void deleteById(String employeeId);

    List<Employee> findByFirstNameAndLastName (String firstName , String lastName);

}
