package com.example.mongo.repository;

import com.example.mongo.dto.EmployeeCountResponse;
import com.example.mongo.entity.Employee;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface EmployeeCustomRepository {

    List<Employee> findAllUsingTemplate(String firstName);

    List<Employee> isActive();

    Employee findOneEmployee(String lastName);

    List<Employee> displayOnlyFirsName();

    UpdateResult updateDepartmentById(String employeeID);

    List<EmployeeCountResponse> countInEachDepartment();

    List<EmployeeCountResponse> countInEachDepartmentByAge();

}
