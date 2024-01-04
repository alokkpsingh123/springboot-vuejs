package com.example.demoredis.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demoredis.entity.Employee;

import com.example.demoredis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by ppatchava on 11/28/19.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String EMPLOYEECOLLECTION = "Employee";

    private RedisTemplate<String, Employee> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public EmployeeRepositoryImpl(RedisTemplate<String, Employee> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        this.hashOps = this.redisTemplate.opsForHash();
    }

    public List<Employee> findAll(){
        Map<String,Employee> allElements = hashOps.entries(EMPLOYEECOLLECTION);
        return allElements.values().stream().collect(Collectors.toList());
    }

    public Employee findOne(String employeeId){
        return (Employee) hashOps.get(EMPLOYEECOLLECTION,employeeId);
    }

    public Employee save(Employee employee){
        hashOps.put(EMPLOYEECOLLECTION,employee.getEmployeeId(),employee);
        return employee;
    };

    public Employee insert(Employee employee){
        hashOps.put(EMPLOYEECOLLECTION,employee.getEmployeeId(),employee);
        return employee;
    }

    public void delete(String employeeId){
        hashOps.delete(EMPLOYEECOLLECTION,employeeId);
    }

    public void deleteAll(){
        Set<String> keys= hashOps.keys(EMPLOYEECOLLECTION);
        for(String key:keys){
            hashOps.delete(EMPLOYEECOLLECTION,key);
        }
    }

    public boolean exists(String employeeId){
        return hashOps.hasKey(EMPLOYEECOLLECTION,employeeId);
    }

    public Long count(){
        return hashOps.size(EMPLOYEECOLLECTION);
    }
}
