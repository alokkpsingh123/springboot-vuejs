package com.example.inmemory.repository;

import com.example.inmemory.entity.Employee;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.List;

public interface EmployeeRepository {

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(String employeeId);

    List<Employee> getAllEmployee();

    boolean deleteEmployeeById(String employeeId);

    boolean existsByEmployeeId(String employeeId);

    boolean deleteAllEmployee();
}
