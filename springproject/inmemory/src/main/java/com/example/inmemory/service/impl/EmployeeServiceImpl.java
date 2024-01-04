package com.example.inmemory.service.impl;

import com.example.inmemory.dto.EmployeeDto;
import com.example.inmemory.dto.EmployeeResponseDto;
import com.example.inmemory.entity.Employee;
import com.example.inmemory.repository.EmployeeMongoRepository;
import com.example.inmemory.repository.EmployeeRepository;
import com.example.inmemory.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMongoRepository employeeMongoRepository;

    @Override
    public boolean addEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setDob(new Date(employeeDto.getDateOfBirth()));
        employee.setDoj(new Date(employeeDto.getDateOfJoining()));
        employee.setEmployeeId(UUID.randomUUID().toString());
//        Employee saveEmployee = employeeRepository.addEmployee(employee);
//        Objects.nonNull(saveEmployee)

        Employee savedEmployee = employeeMongoRepository.save(employee);
        return Objects.nonNull(savedEmployee);

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeMongoRepository.findAll();
        return employeeList;
    }

    @Override
    public boolean clearAll() {
        employeeMongoRepository.deleteAll();
        return true;
    }

    @Override
    public Employee get(String employeeId) {

         Optional<Employee> employeeOptional= employeeMongoRepository.findById(employeeId);
         return employeeOptional.isPresent() ? employeeOptional.get() : null;
    }

    @Override
    public boolean deleteById(String employeeId) {
        employeeMongoRepository.deleteById(employeeId);
        return true;
    }

    @Override
    public boolean isEmployeeExist(String employeeId) {
       return employeeMongoRepository.existsById(employeeId);
    }


}
