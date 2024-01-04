package com.example.mongo.dto;

import com.example.mongo.entity.Employee;
import lombok.Data;

@Data
public class EmployeeCountResponse {

    private String department;
    private int count;

}
