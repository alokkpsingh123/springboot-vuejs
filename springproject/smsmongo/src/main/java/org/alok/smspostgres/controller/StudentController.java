package org.alok.smspostgres.controller;


import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.*;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Student;
import org.alok.smspostgres.service.RegistrationService;
import org.alok.smspostgres.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code written by: Alok Singh on 26/11/23
 */

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    RegistrationService registrationService;

    /**
     *
     * @param stdId not null
     * @return the student details with given studentId
     */
    @GetMapping("/getStudentDetails/{stdId}")
    public ResponseEntity<StudentResponseDTO> getStudentDetail(@PathVariable String stdId){
        return ResponseEntity.ok(studentService.getStudentDetail(stdId));
    }

    /**
     *
     * @param stdId not null
     * @return the progress of the student
     */
    @GetMapping("/getCourseProgress/{stdId}")
    public ResponseEntity<List<CourseProgressDTO>> getCourseProgress(@PathVariable String stdId){
        List<CourseProgressDTO> courseProgressDTOList = studentService.getCourseProgress(stdId);
        return ResponseEntity.ok(courseProgressDTOList);
    }

    /**
     * Registration of Student
     * @param studentDTO
     * @return
     */
    @PostMapping("/registerStudent")
    ResponseEntity<StudentSaveResponseDTO> registerStudent(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student.setDateOfBirth(new Date(studentDTO.getDob()));
        return ResponseEntity.ok(studentService.registerStudent(student));
    }

    /**
     * De-Register the student
     * @param stdId not null
     * @return
     */
    @DeleteMapping("/deRegisterStudent/{stdId}")
    ResponseEntity<Map<String,Boolean>> deRegisterStudent(@PathVariable String stdId){
        studentService.deRegisterStudent(stdId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /**
     * Updating the student details
     * @param studentDTO
     * @return
     */
    @PutMapping("/updateStudentDetails")
    ResponseEntity<StudentSaveResponseDTO> updateStudentDetails(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student.setDateOfBirth(new Date(studentDTO.getDob()));
        return ResponseEntity.ok(studentService.updateStudentDetails(student));
    }

    /**
     * Register for the course
     * @param studentId not null
     * @param courseId not null
     * @return
     */
    @PostMapping("/enrollForCourse")
    ResponseEntity<Map<String,Boolean>> enrollForCourse(@RequestParam("stdId") String studentId, @RequestParam("couId") String courseId){
        registrationService.registerStudentForCourse(studentId, courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("enrolled",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    /**
     * Withdraw from the course
     * @param studentId not null
     * @param courseId not null
     * @return
     */
    @PostMapping("/withdrawCourse")
    ResponseEntity<Map<String,Boolean>> withdrawCourse(@RequestParam("stdId") String studentId, @RequestParam("couId") String courseId){
        registrationService.withdrawStudentFromCourse(studentId, courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("enrolled",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
