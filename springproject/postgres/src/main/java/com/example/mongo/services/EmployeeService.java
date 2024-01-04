package com.example.mongo.services;

import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(EmployeeDto employeeDto);

    Iterable<Employee> findAll();

    Optional<Employee> findOne(String bankId);

//    Optional<Employee> updateFirstNameByEmpId(String fname, String employeeId);

//    public Employee addEmployee(Employee employee);
//
//    public Iterable<Employee> getAll();
//
//    public boolean clearAll();
//
//    public Employee get(String employeeId);
//
//    public boolean deleteById(String employeeId);
//
//    public boolean isEmployeeExist(String employeeId);

//    List<Employee> fetchByFnameAndLname(String firstName, String lastName);
//
//    List<Employee> fetchEmployeesByFistName(String name);
//
//    List<Employee> findAllUsingTemplate(String firstName);
//
//    List<Employee> fetchEmployeesByFirstNameSortByDob(String name);
//
//    List<Employee> isActive();
//
//    Employee findOneEmployee(String lastName);
//
//    List<Employee> displayOnlyFirsName();
//
//    UpdateResult updateDepartmentById(String employeeId);
}