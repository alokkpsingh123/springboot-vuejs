package com.example.mongo.dto;

import com.example.mongo.entity.BankAccount;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {

    private String employeeId;
    private String firstName;
    private String lastName;
    private long dateOfBirth;
    private long dateOfJoining;
    private int age;
    private String department;
    private boolean isActive;
    private String companyId;
    private String bankAccountId;
}
