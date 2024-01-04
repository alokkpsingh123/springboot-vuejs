package com.example.mongo.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private Long dateOfBirth;
    private Long dateOfJoining;
    private Boolean isActive;
}
