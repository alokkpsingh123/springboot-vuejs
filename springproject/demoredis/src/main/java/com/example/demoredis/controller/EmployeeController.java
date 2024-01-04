package com.example.demoredis.controller;

import java.util.List;
import java.util.ArrayList;

import com.example.demoredis.dto.EmployeeDTO;
import com.example.demoredis.entity.Employee;
import com.example.demoredis.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ppatchava on 11/28/19.
 */

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employeeList = employeeService.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOS.add(employeeDTO);
        }

        return new ResponseEntity<List<EmployeeDTO>>(employeeDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(employeeService.count(), HttpStatus.OK);
    }

    @GetMapping(value = "/findOne/{employeeId}")
    public ResponseEntity<?> getOne(@PathVariable("employeeId") String employeeId) {
        Employee employee = employeeService.findOne(employeeId);
        EmployeeDTO employeeDTO = new EmployeeDTO();

        if (employee == null) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }

        BeanUtils.copyProperties(employee, employeeDTO);
        return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/exists/{employeeId}")
    public ResponseEntity<Boolean> exists(@PathVariable("employeeId") String employeeId) {
        return new ResponseEntity<Boolean>(employeeService.exists(employeeId), HttpStatus.OK);
    }

    @DeleteMapping( value = "/delete/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable("employeeId") String employeeId) {
        employeeService.delete(employeeId);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<Boolean> deleteAll() {
        employeeService.deleteAll();
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping( value = "/addOrUpdate")
    public ResponseEntity<String> addOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO) {

        System.out.println(employeeDTO);

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Employee employeeCreated = employeeService.insertOrUpdate(employee);

        return new ResponseEntity<String>(employeeCreated.getEmployeeId(), HttpStatus.CREATED);
    }


    @GetMapping("/getAllViaPostgres")
    public List<EmployeeDTO> getAllViaPostgres() {
        return employeeService.getAllViaPostgres();
    }

    @PostMapping
    public Employee insertEployeeViaPostgres(EmployeeDTO employeeDTO) {
        return employeeService.insertEployeeViaPostgres(employeeDTO);
    }
}
