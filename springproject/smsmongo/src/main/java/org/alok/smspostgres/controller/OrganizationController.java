package org.alok.smspostgres.controller;

import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.*;
import org.alok.smspostgres.service.CourseService;
import org.alok.smspostgres.service.InstructorService;
import org.alok.smspostgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code written by: Alok Singh on 26/11/23
 */

@RestController
@RequestMapping("/organization")
@Slf4j
public class OrganizationController {

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentCountEnrolledOrganization")
    ResponseEntity<Map<String,Long>> getStudentCountEnrolledOrganization(){
        Map<String, Long> response = new HashMap<>();
        response.put("enrolled", studentService.getStudentCountEnrolledOrganization());
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getStudentCountEnrolledCourse")
    ResponseEntity<List<CourseCountByStudentDTO>> getStudentCountEnrolledCourse(){
        return ResponseEntity.ok(courseService.getStudentCountEnrolledCourse());
    }

    @GetMapping("/getInstructorDetailsForCourses")
    ResponseEntity<List<InstructorCourseDTO>> getInstructorDetailsForCourses(){
        return ResponseEntity.ok(instructorService.getInstructorDetailsForCourses());
    }

    @GetMapping("/getInstructorCount")
    ResponseEntity<Map<String,Long>> getInstructorCount(){
        Map<String, Long> response = new HashMap<>();
        response.put("enrolled", instructorService.getInstructorCount());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getInstructorDetailsForCourses/{courseId}")
    ResponseEntity<List<CourseDetailsDTO>> getDetailsByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(courseService.getDetailsByCourseId(courseId));
    }

    @GetMapping("/getStudentsByCourseStatus")
    ResponseEntity<List<StudentCourseDTO>> getStudentsByCourseStatus(@RequestParam("courseStatus") String courseStatus){
        return ResponseEntity.ok(studentService.getStudentsByCourseStatus(courseStatus));
    }



}
