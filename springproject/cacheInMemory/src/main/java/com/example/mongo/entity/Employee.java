package com.example.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private String employeeId;

    private String firstName;

    private String lastName;

    private Date dob;

    private Date doj;

    private boolean isActive;
}
