package com.example.demoredis.repository;

import java.util.List;
import com.example.demoredis.entity.Employee;

/**
 * Created by ppatchava on 11/28/19.
 */
public interface EmployeeRepository {
    public List<Employee> findAll();

    public Employee findOne(String employeeId);

    public Employee save(Employee employee);

    public Employee insert(Employee employee);

    public void delete(String employeeId);

    public void deleteAll();

    public boolean exists(String employeeId);

    public Long count();
}
