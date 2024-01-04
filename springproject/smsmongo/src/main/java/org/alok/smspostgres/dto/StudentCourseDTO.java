package org.alok.smspostgres.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentCourseDTO {

    private String studentId;
    private String studentName;
    private String courseName;
    private String courseProgress;
    private Date dateOfBirth;

    public StudentCourseDTO(String studentId, String studentName, String courseName, String courseProgress, Date dateOfBirth) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseProgress = courseProgress;
        this.dateOfBirth = dateOfBirth;
    }
}
