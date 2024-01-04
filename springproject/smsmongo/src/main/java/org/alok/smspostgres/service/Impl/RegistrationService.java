package org.alok.smspostgres.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Instructor;
import org.alok.smspostgres.entity.Student;
import org.alok.smspostgres.repository.CourseRepository;
import org.alok.smspostgres.repository.InstructorRepository;
import org.alok.smspostgres.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.font.CoreMetrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class RegistrationService implements org.alok.smspostgres.service.RegistrationService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void registerStudentForCourse(String studentId, String courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if(studentOptional.isPresent() && courseOptional.isPresent()){
            studentOptional.get().getCourses().add(courseOptional.get());
            studentRepository.save(studentOptional.get());
        }else {
            log.error("either student or course is not present");
        }

    }

    @Override
    public void withdrawStudentFromCourse(String studentId, String courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if(studentOptional.isPresent() && courseOptional.isPresent()){
            studentOptional.get().getCourses().remove(courseOptional.get());
            studentRepository.save(studentOptional.get());
        }else {
            log.error("either student or course is not present");
        }

    }

    @Override
    public void registerInstructorForCourse(String instructorId, String courseId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (instructorOptional.isPresent() && courseOptional.isPresent()) {
            instructorOptional.get().setCourse(courseOptional.get());
            courseOptional.get().setInstructor(instructorOptional.get());

            instructorRepository.save(instructorOptional.get());
            courseRepository.save(courseOptional.get());
        } else {
            log.error("either instructor or course is not present");
        }

    }

    @Override
    public void withdrawInstructorFromCourse(String instructorId, String courseId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (instructorOptional.isPresent() && courseOptional.isPresent()) {

            if (courseOptional.get().getCourseId() == instructorOptional.get().getCourse().getCourseId()) {
                instructorOptional.get().setCourse(null);
                courseOptional.get().setInstructor(null);
            } else {
                log.debug("Course does not belong to instructor");
            }
            instructorRepository.save(instructorOptional.get());
            courseRepository.save(courseOptional.get());
        } else {
            log.error("either instructor or course is not present");
        }
    }
}
