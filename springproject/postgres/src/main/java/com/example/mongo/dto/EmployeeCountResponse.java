package com.example.mongo.dto;

import com.example.mongo.entity.Employee;
import lombok.Data;
import lombok.Setter;

@Data
public class EmployeeCountResponse {

    private Employee department;
    private int count;

}
