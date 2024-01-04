package org.alok.smspostgres.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private String studentId;
    private String studentName;
    private long dob;
}
