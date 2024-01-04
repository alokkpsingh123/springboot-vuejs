package com.example.mongo.controller;

import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.Employee;
import com.example.mongo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //localjpst:8090/employee--> Post request is handled here

    //consumes - xml
    //produce - simpleText
    @PostMapping
    public ResponseEntity<Boolean> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(){
        List<Employee> data = employeeService.getAllEmployees();
        List<EmployeeResponseDto> responseDtos= new ArrayList<>();
        for(Employee employee : data ){
            EmployeeResponseDto employeeDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee,employeeDto);
            employeeDto.setDateOfBirth(employee.getDob().getTime());
            employeeDto.setDateOfJoining(employee.getDoj().getTime());
            responseDtos.add(employeeDto);
        }
        return  ResponseEntity.ok(responseDtos);
    }


    @DeleteMapping
    private ResponseEntity<Boolean> deleteAll(){

        employeeService.clearAll();

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping
    public ResponseEntity<Boolean> editEmployee(@RequestBody EmployeeDto employeeDto , @RequestParam("employeeId") String employeeId){

        return ResponseEntity.ok(employeeService.editEmployee(employeeDto , employeeId));
    }



    @DeleteMapping("/id/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable String employeeId){
        Employee employee = employeeService.getByEmployeeId(employeeId);
        if(employee == null){
            return ResponseEntity.ok(Boolean.FALSE);
        }

        employeeService.deleteById(employeeId);

        return ResponseEntity.ok(Boolean.TRUE);

    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<List<EmployeeResponseDto>> findByFirstNameAndLastName (@PathVariable String firstName , @PathVariable String lastName){

        List<Employee> data = employeeService.findByFirstNameAndLastName(firstName,lastName);
        List<EmployeeResponseDto> responseDtos= new ArrayList<>();
        for(Employee employee : data ){
            EmployeeResponseDto employeeDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee,employeeDto);
            employeeDto.setDateOfBirth(employee.getDob().getTime());
            employeeDto.setDateOfJoining(employee.getDoj().getTime());
            responseDtos.add(employeeDto);
        }
        return  ResponseEntity.ok(responseDtos);


    }

    @GetMapping("/id/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable String employeeId) {
        Employee employee = employeeService.getByEmployeeId(employeeId);

        if(employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployeeResponseDto employeeDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(employee,employeeDto);
        employeeDto.setDateOfBirth(employee.getDob().getTime());
        employeeDto.setDateOfJoining(employee.getDoj().getTime());

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
