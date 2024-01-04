package com.example.demoredis.services;

import java.util.List;

import com.example.demoredis.dto.EmployeeDTO;
import com.example.demoredis.entity.Employee;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created by ppatchava on 11/28/19.
 */
public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findOne(String employeeId);

    public Employee insertOrUpdate(Employee employee);

    public void delete(String employeeId);

    public void deleteAll();

    public boolean exists(String employeeId);

    public Long count();

    List<EmployeeDTO> getAllViaPostgres();

    Employee insertEployeeViaPostgres(EmployeeDTO employeeDTO);
}
