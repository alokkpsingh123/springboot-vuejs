package org.alok.smspostgres.service;

import org.alok.smspostgres.dto.InstructorCourseDTO;
import org.alok.smspostgres.dto.InstructorDTO;
import org.alok.smspostgres.dto.InstructorResposeDTO;
import org.alok.smspostgres.entity.Instructor;
import org.alok.smspostgres.entity.Student;

import java.util.List;

public interface InstructorService {

    InstructorResposeDTO registerInstructor(Instructor instructor);

    void deRegisterInstructor(String instructorId);

    InstructorResposeDTO updateInstructorDetails(Instructor instructor);

    void enrollForCourse(String instructorId, String courseId);

    void withdrawCourse(String instructorId, String courseId);

    void courseUpdation(String studentId, String courseStatus, String courseId);

    List<InstructorCourseDTO> getInstructorDetailsForCourses();

    long getInstructorCount();

}
