package com.example.mongo.services.impl;

import com.example.mongo.dto.EmployeeCountResponse;
import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.EmployeeCustomRepository;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.services.EmployeeService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCustomRepository employeeCustomRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public boolean clearAll() {
        employeeRepository.deleteAll();
        return true;
    }


    @Override
    @Cacheable(cacheNames = "employees" , key = "#employee.employeeId")
    public Employee get(String employeeId) {

        Optional<Employee> employeeOptional= employeeRepository.findById(employeeId);
        return employeeOptional.isPresent() ? employeeOptional.get() : null;
    }

    @Override
    public boolean deleteById(String employeeId) {
        employeeRepository.deleteById(employeeId);
        return true;
    }

    @Override
    public boolean isEmployeeExist(String employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    @Override
    public List<Employee> fetchByFnameAndLname(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Employee> fetchEmployeesByFistName(String name) {
        return employeeRepository.fetchEmployeesByFistName(name);
    }

    @Override
    public List<Employee> fetchEmployeesByFirstNameSortByDob(String name) {
        return employeeRepository.fetchEmployeesByFirstNameSortByDob(name);
    }

    @Override
    public List<Employee> findAllUsingTemplate(String firstName) {
        return employeeCustomRepository.findAllUsingTemplate(firstName);
    }

    @Override
    public List<Employee> isActive() {
        return employeeCustomRepository.isActive();
    }

    @Override
    public Employee findOneEmployee(String lastName) {
        return employeeCustomRepository.findOneEmployee(lastName);
    }

    @Override
    public List<Employee> displayOnlyFirsName() {
        return employeeCustomRepository.displayOnlyFirsName();
    }

    @Override
    public UpdateResult updateDepartmentById(String employeeId) {
        return null;
    }

    @Override
    public List<EmployeeCountResponse> getCountOfEmployeeInEachDept() {
        return null;
    }

    @Override
    public List<EmployeeCountResponse> countInEachDepartment() {

        return employeeCustomRepository.countInEachDepartment();
    }

    @Override
    public List<EmployeeCountResponse> countInEachDepartmentByAge() {
        return employeeCustomRepository.countInEachDepartmentByAge();
    }

//    @Override
//    public UpdateResult updateDepartmentById(Employee employeeId) {
//        return employeeCustomRepository.updateDepartmentById(employeeId);
//    }


}
