package org.alok.smspostgres.service.Impl;


import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.CourseCountByStudentDTO;
import org.alok.smspostgres.dto.CourseDTO;
import org.alok.smspostgres.dto.CourseDetailsDTO;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.repository.CourseRepository;
import org.alok.smspostgres.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public CourseDTO registerCourse(Course course) {

        CourseDTO courseDTO = new CourseDTO();
        course = courseRepository.save(course);
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    @Override
    public void deRegisterCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<CourseCountByStudentDTO> getStudentCountEnrolledCourse() {
        return courseRepository.getStudentCountEnrolledCourse();
    }

    @Override
    public List<CourseDetailsDTO> getDetailsByCourseId(String courseId) {
        return courseRepository.getDetailsByCourseId(courseId);
    }
}
