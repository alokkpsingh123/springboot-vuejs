package com.example.mongo.services;

import com.example.mongo.dto.EmployeeCountResponse;
import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.Employee;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeService {



    public Employee addEmployee(Employee employee);

    public List<Employee> getAll();

    public boolean clearAll();

    public Employee get(String employeeId);

    public boolean deleteById(String employeeId);

    public boolean isEmployeeExist(String employeeId);

    List<Employee> fetchByFnameAndLname(String firstName, String lastName);

    List<Employee> fetchEmployeesByFistName(String name);

    List<Employee> findAllUsingTemplate(String firstName);

    List<Employee> fetchEmployeesByFirstNameSortByDob(String name);

    List<Employee> isActive();

    Employee findOneEmployee(String lastName);

    List<Employee> displayOnlyFirsName();

    UpdateResult updateDepartmentById(String employeeId);

    List<EmployeeCountResponse> getCountOfEmployeeInEachDept();

    public List<EmployeeCountResponse> countInEachDepartment();

    public List<EmployeeCountResponse> countInEachDepartmentByAge();

}