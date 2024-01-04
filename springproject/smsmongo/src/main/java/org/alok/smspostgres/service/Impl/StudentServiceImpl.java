package org.alok.smspostgres.service.Impl;


import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.*;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Student;
import org.alok.smspostgres.repository.StudentRepository;
import org.alok.smspostgres.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RegistrationService registrationService;


    @Override
    public StudentSaveResponseDTO registerStudent(Student student) {
        StudentSaveResponseDTO studentSaveResponseDTO = new StudentSaveResponseDTO();
        student = studentRepository.save(student);
        BeanUtils.copyProperties(student, studentSaveResponseDTO);
        return studentSaveResponseDTO;
    }

    @Override
    public void deRegisterStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentSaveResponseDTO updateStudentDetails(Student student) {

        Optional<Student> studentOptional = studentRepository.findById(student.getStudentId());
        if(studentOptional.isPresent()){
            StudentSaveResponseDTO studentSaveResponseDTO = new StudentSaveResponseDTO();
            student = studentRepository.save(student);
            BeanUtils.copyProperties(student,studentSaveResponseDTO);
            return studentSaveResponseDTO;
        }else {
            log.error("Student does not exist");
            return null;
        }

    }


    @Override
    public List<CourseProgressDTO> getCourseProgress(String studentId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Course> courses = student.getCourses();

            List<CourseProgressDTO> courseProgressList = new ArrayList<>();
            for (Course course : courses) {
                CourseProgressDTO courseProgress = new CourseProgressDTO();
                courseProgress.setCourseName(course.getCourseName());
                courseProgress.setCourseProgress(course.getCourseProgress());
                courseProgressList.add(courseProgress);
            }

            return courseProgressList;
        }else {
            log.error("Student does not exist");
            return null;
        }
    }

    @Override
    public StudentResponseDTO getStudentDetail(String studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            studentResponseDTO.setStudentId(student.getStudentId());
            studentResponseDTO.setStudentName(student.getStudentName());
            studentResponseDTO.setDateOfBirth(student.getDateOfBirth());
            List<Course> courseList = studentOptional.get().getCourses();
            List<String> courseResponse = new ArrayList<>();
            for (Course course: courseList){
                courseResponse.add(course.getCourseName());
            }
            studentResponseDTO.setCourses(courseResponse);

            return studentResponseDTO;
        } else {
            log.error("Student does not exist");
            return null;
        }
    }


    @Override
    public List<StudentDTO> findAllStudent() {
        Iterable<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : studentList){
            StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(student, studentDTO);
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public long getStudentCountEnrolledOrganization() {
        return studentRepository.getStudentCount();
    }

    @Override
    public List<StudentCourseDTO> getStudentsByCourseStatus(String courseStatus) {
        return studentRepository.getStudentsByCourseStatus(courseStatus);
    }
}
