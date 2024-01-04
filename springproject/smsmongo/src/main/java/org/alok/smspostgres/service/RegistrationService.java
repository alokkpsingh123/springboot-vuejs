package org.alok.smspostgres.service;

import org.alok.smspostgres.entity.Course;
import sun.font.CoreMetrics;

public interface RegistrationService {

    void registerStudentForCourse(String studentId, String courseId);

    void withdrawStudentFromCourse(String studentId, String courseId);

    void registerInstructorForCourse(String instructorId, String courseId);

    void withdrawInstructorFromCourse(String instructorId, String courseId);
}
