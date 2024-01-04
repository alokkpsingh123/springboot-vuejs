package com.example.inmemory.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Date;


@Data
@Document(collection = "employee")
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private Date dob;
    private Date doj;

}
