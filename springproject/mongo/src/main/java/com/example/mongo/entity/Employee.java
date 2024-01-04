package com.example.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document(collection = Employee.COLLECTION_NAME)
public class Employee {

    public static final String COLLECTION_NAME = "employee";

    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private int age;
    private String department;
    private Date dob;
    private Date doj;
    private boolean isActive;
}
