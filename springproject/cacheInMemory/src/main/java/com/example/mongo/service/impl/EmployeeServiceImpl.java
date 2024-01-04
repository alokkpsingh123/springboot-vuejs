package com.example.mongo.service.impl;


import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setDob(new Date(employeeDto.getDateOfBirth()));
        employee.setDoj(new Date(employeeDto.getDateOfJoining()));

        Employee savedEmployee = employeeRepository.save(employee);

        return Objects.nonNull(savedEmployee);


    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void clearAll(){

        employeeRepository.deleteAll();
    }




    @Override
   @CacheEvict(cacheNames = "employees", key = "#employees.employeeId")
    public boolean editEmployee(EmployeeDto employeeDto , String employeeId){
        Employee employee = employeeRepository.findById(employeeId).get();
        if(employee!= null){
//            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employee.setDob(new Date(employeeDto.getDateOfBirth()));
            employee.setDoj(new Date(employeeDto.getDateOfJoining()));

            System.out.println("Inside Evict");
            Employee savedEmployee = employeeRepository.save(employee);
            return Objects.nonNull(savedEmployee);


        }
        return Boolean.FALSE;

    }

    @Override
    @Cacheable(cacheNames= "employees" , key ="#employeeId" )
    public Employee getByEmployeeId(String employeeId){
        Optional<Employee> emplyeeOptional = employeeRepository.findById(employeeId);
        //Optional
        System.out.println("inside getByOne");
        if(emplyeeOptional.isPresent()){
        return emplyeeOptional.get();
        }
        return null;
    }

    @Override
    public List<Employee> findByFirstNameAndLastName (String firstName , String lastName){
        return employeeRepository.findByFirstNameAndLastName(firstName,lastName);

    }




    @Override
    public void deleteById(String employeeId){
        employeeRepository.deleteById(employeeId);


    }

}

