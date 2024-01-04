package org.alok.smspostgres.dto;

import lombok.Data;

@Data
public class InstructorCourseDTO {
    private String courseId;
    private String courseName;
    private String instructorId;
    private String instructorName;

    public InstructorCourseDTO(String courseId, String courseName, String instructorId, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }
}
