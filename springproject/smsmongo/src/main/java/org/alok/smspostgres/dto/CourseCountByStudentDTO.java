package org.alok.smspostgres.dto;


import lombok.Data;

@Data
public class CourseCountByStudentDTO {
    private String courseId;
    private String courseName;
    private long studentCount;

    public CourseCountByStudentDTO(String courseId, String courseName, long studentCount) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentCount = studentCount;
    }
}
