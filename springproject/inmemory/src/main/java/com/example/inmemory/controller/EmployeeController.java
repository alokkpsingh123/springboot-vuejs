package com.example.inmemory.controller;


import com.example.inmemory.dto.EmployeeDto;
import com.example.inmemory.dto.EmployeeResponseDto;
import com.example.inmemory.entity.Employee;
import com.example.inmemory.service.EmployeeService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * url : //localhost:8090/employee
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public boolean addEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);

    }

    @GetMapping
    public List<EmployeeResponseDto> getAll(){
        List<Employee> employeeList = employeeService.getAll();
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee, employeeResponseDto);
            employeeResponseDto.setDateOfBirth(employee.getDob().getTime());
            employeeResponseDto.setDateOfJoining(employee.getDoj().getTime());
            responseDtos.add(employeeResponseDto);
        }

        return responseDtos;
    }

    @GetMapping("/id/{employeeId}")
    public EmployeeResponseDto get( @PathVariable String employeeId){
        Employee employee = employeeService.get(employeeId);
        if(employee == null){
            return  null;
        }
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(employee, employeeResponseDto);
        employeeResponseDto.setDateOfBirth(employee.getDob().getTime());
        employeeResponseDto.setDateOfJoining(employee.getDoj().getTime());

        return employeeResponseDto;
    }

    @DeleteMapping("/delete/{employeeId}")
    public boolean deleteById( @PathVariable String employeeId){
        boolean result = false;
        if(employeeService.isEmployeeExist(employeeId)){
            result = employeeService.deleteById(employeeId);
        }
        return result;
    }

    @GetMapping("/id")
    public boolean isEmployeeExist(@RequestParam("empId") String employeeId){
        boolean result = employeeService.isEmployeeExist( employeeId);
        return result;
    }



    @DeleteMapping
    public boolean deleteAll(){
        employeeService.clearAll();
        return Boolean.TRUE;
    }
}
