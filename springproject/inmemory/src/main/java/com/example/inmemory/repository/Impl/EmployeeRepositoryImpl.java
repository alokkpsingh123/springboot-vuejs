package com.example.inmemory.repository.Impl;

import com.example.inmemory.entity.Employee;
import com.example.inmemory.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {


    private Map<String, Employee> data = null;

    @PostConstruct
    public void init(){
        data = new HashMap<>();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        data.put(employee.getEmployeeId(), employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return data.get(employeeId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(data.values());
    }

    @Override
    public boolean deleteEmployeeById(String employeeId) {
        Employee deleteObj = data.get(employeeId);
        return data.remove(employeeId, deleteObj);
    }

    @Override
    public boolean existsByEmployeeId(String employeeId) {
        return data.containsKey(employeeId);
    }

    @Override
    public boolean deleteAllEmployee() {
        data.clear();
        if( data.isEmpty()){
            return  true;
        }
        return false;
    }
}
