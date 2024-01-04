package com.example.inmemory.service;

import com.example.inmemory.dto.EmployeeDto;
import com.example.inmemory.dto.EmployeeResponseDto;
import com.example.inmemory.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public boolean addEmployee(EmployeeDto employeeDto);

    public List<Employee> getAll();

    public boolean clearAll();

    public Employee get(String employeeId);

    public boolean deleteById(String employeeId);

    public boolean isEmployeeExist(String employeeId);
}
