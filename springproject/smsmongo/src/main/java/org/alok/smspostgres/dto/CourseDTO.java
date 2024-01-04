package org.alok.smspostgres.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private String courseId;
    private String courseName;
    private Double courseFee;
    private String courseProgress;
}
