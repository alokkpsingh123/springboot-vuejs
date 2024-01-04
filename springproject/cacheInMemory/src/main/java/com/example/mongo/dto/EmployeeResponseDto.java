package com.example.mongo.dto;
import lombok.Data;

@Data
public class EmployeeResponseDto {

    private String employeeId;
    private String firstName;
    private String lastName;
    private long dateOfBirth;
    private long dateOfJoining;

}
