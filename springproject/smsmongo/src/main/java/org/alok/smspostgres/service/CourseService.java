package org.alok.smspostgres.service;

import org.alok.smspostgres.dto.CourseCountByStudentDTO;
import org.alok.smspostgres.dto.CourseDTO;
import org.alok.smspostgres.dto.CourseDetailsDTO;
import org.alok.smspostgres.entity.Course;

import java.util.List;

public interface CourseService {


    CourseDTO registerCourse(Course course);

    void deRegisterCourse(String courseId);

    List<CourseCountByStudentDTO> getStudentCountEnrolledCourse();

    List<CourseDetailsDTO> getDetailsByCourseId(String courseId);
}
