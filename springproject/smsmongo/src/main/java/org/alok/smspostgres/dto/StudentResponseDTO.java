package org.alok.smspostgres.dto;

import lombok.Data;
import org.alok.smspostgres.entity.Course;

import java.util.Date;
import java.util.List;

@Data
public class StudentResponseDTO {

    private String studentId;
    private String studentName;
    private Date dateOfBirth;
    private List<String> courses;
}
