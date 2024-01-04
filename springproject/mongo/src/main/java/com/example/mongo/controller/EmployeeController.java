package com.example.mongo.controller;

import com.example.mongo.dto.EmployeeCountResponse;
import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.Employee;
import com.example.mongo.services.EmployeeService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Written by: Alok Singh on 23/11/23
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.addEmployee(getEmployeeObject(employeeDto));

    }

    @GetMapping
    public List<EmployeeResponseDto> getAll(){

        List<Employee> employeeList = employeeService.getAll();
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/id/{employeeId}")
    public EmployeeResponseDto get( @PathVariable String employeeId){
        Employee employee = employeeService.get(employeeId);
        if(employee == null){
            return  null;
        }

        return getEmployeeResponseDtoObject(employee);
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

    @GetMapping("/fal")
    public List<EmployeeResponseDto> getByFirstNameAndLastName(@RequestParam("fn") String firstName, @RequestParam("ln") String lastName){

        List<Employee> employeeList = employeeService.fetchByFnameAndLname(firstName, lastName);
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/bf")
    public List<EmployeeResponseDto> getByFirstName(@RequestParam("fn") String firstName){

        List<Employee> employeeList = employeeService.fetchEmployeesByFistName(firstName);
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/bfasbd")
    public List<EmployeeResponseDto> getByFirstNameAndSort(@RequestParam("fn") String firstName){

        List<Employee> employeeList = employeeService.fetchEmployeesByFirstNameSortByDob(firstName);
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/query1")
    public List<EmployeeResponseDto> getQueryOne(@RequestParam("fn") String firstName){

        List<Employee> employeeList = employeeService.findAllUsingTemplate(firstName);
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/query2")
    public EmployeeResponseDto getQueryTwo(@RequestParam("ln") String lastName){
        return getEmployeeResponseDtoObject(employeeService.findOneEmployee(lastName));
    }

    @GetMapping("/query3")
    public List<EmployeeResponseDto> getQueryThird(){

        List<Employee> employeeList = employeeService.isActive();
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }

    @GetMapping("/query4")
    public List<EmployeeResponseDto> getQueryFourth(){

        List<Employee> employeeList = employeeService.displayOnlyFirsName();
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for( Employee employee : employeeList){
            responseDtos.add(getEmployeeResponseDtoObject(employee));
        }

        return responseDtos;
    }


    @GetMapping("/update/department/byId/{employeeId}")
    public UpdateResult updateDepartmentById( @PathVariable String employeeId){
        return employeeService.updateDepartmentById(employeeId);
    }


    @GetMapping("/get/employeeCountInEachDept")
    public List<EmployeeCountResponse> getCountOfEmployeeInEachDept(){
        return employeeService.getCountOfEmployeeInEachDept();
    }

    @GetMapping("/countInEachDepartment")
    public List<EmployeeCountResponse> countInEachDepartment(){
        return employeeService.countInEachDepartment();
    }

    @GetMapping("/countInEachDepartmentByAge")
    public List<EmployeeCountResponse> countInEachDepartmentByAge(){
        return employeeService.countInEachDepartmentByAge();
    }


    private Employee getEmployeeObject(EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setDob(new Date(employeeDto.getDateOfBirth()));
        employee.setDoj(new Date(employeeDto.getDateOfJoining()));

        return  employee;
    }

    private EmployeeResponseDto getEmployeeResponseDtoObject(Employee employee){
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(employee, employeeResponseDto);
        employeeResponseDto.setDateOfBirth(employee.getDob().getTime());
        employeeResponseDto.setDateOfJoining(employee.getDoj().getTime());

        return employeeResponseDto;
    }
}

