package com.example.inmemory.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private long dateOfBirth;
    private long dateOfJoining;

}
