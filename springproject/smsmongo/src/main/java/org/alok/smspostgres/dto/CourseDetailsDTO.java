package org.alok.smspostgres.dto;

import lombok.Data;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Instructor;
import org.alok.smspostgres.entity.Student;

@Data
public class CourseDetailsDTO {
    private Student student;
    private Course course;
    private Instructor instructor;

    public CourseDetailsDTO(Student student, Course course, Instructor instructor) {
        this.student = student;
        this.course = course;
        this.instructor = instructor;
    }
}
