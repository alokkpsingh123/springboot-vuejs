package org.alok.smspostgres.service;

import org.alok.smspostgres.dto.*;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Student;

import java.util.List;

public interface StudentService {

    StudentSaveResponseDTO registerStudent(Student student);

    void deRegisterStudent(String studentId);

    StudentSaveResponseDTO updateStudentDetails(Student student);

    List<CourseProgressDTO> getCourseProgress(String studentId);

    StudentResponseDTO getStudentDetail(String studentId);


    List<StudentDTO> findAllStudent();

    long getStudentCountEnrolledOrganization();

    List<StudentCourseDTO> getStudentsByCourseStatus(String courseStatus);
}
