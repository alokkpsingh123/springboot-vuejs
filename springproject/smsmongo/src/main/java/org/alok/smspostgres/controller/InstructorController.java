package org.alok.smspostgres.controller;


import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.InstructorDTO;
import org.alok.smspostgres.dto.InstructorResposeDTO;
import org.alok.smspostgres.entity.Instructor;
import org.alok.smspostgres.service.InstructorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Code written by: Alok Singh on 26/11/23
 */

@RestController
@RequestMapping("/instructor")
@Slf4j
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    /**
     * Register the instructor
     * @param instructorDTO
     * @return
     */
    @PostMapping("/registerInstructor")
    ResponseEntity<InstructorResposeDTO> registerInstructor(@RequestBody InstructorDTO instructorDTO){
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDTO, instructor);
        instructor.setDateOfBirth(new Date(instructorDTO.getDateOfBirth()));
        return ResponseEntity.ok(instructorService.registerInstructor(instructor));
    }


    /**
     * Deleting the instructor
     * @param insId
     * @return
     */
    @DeleteMapping("/deRegisterInstructor/{insId}")
    ResponseEntity<Map<String,Boolean>> deRegisterInstructor(@PathVariable String insId){
        instructorService.deRegisterInstructor(insId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("de-registered",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /**
     * Updating instructor details
     * @param instructorDTO
     * @return
     */
    @PutMapping("/updateInstructorDetails")
    ResponseEntity<InstructorResposeDTO> updateInstructorDetails(@RequestBody InstructorDTO instructorDTO){
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDTO, instructor);
        instructor.setDateOfBirth(new Date(instructorDTO.getDateOfBirth()));
        return  ResponseEntity.ok(instructorService.updateInstructorDetails(instructor));

    }

    /**
     * Instructor enrolling for course
     * @param instructorId
     * @param courseId
     * @return
     */
    @PostMapping("/enrollForCourseInstructor")
    ResponseEntity<Map<String,Boolean>> enrollForCourse(@RequestParam("insId") String instructorId, @RequestParam("corId") String courseId){
        instructorService.enrollForCourse(instructorId, courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("enrolled",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /**
     * Instructor withdrawing from course
     * @param instructorId
     * @param courseId
     * @return
     */

    @PostMapping("/withdrawCourseInstructor")
    ResponseEntity<Map<String,Boolean>> withdrawCourse(@RequestParam("indId") String instructorId, @RequestParam("corId") String courseId){
       instructorService.withdrawCourse(instructorId, courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("de-registered",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /**
     * Updating the status of the course
     * for particular student
     * @param studentId
     * @param courseStatus
     * @param courseId
     * @return
     */
    @PostMapping("/courseUpdation")
    ResponseEntity<Map<String,Boolean>> courseUpdation(String studentId, String courseStatus, String courseId){
        instructorService.courseUpdation(studentId, courseStatus, courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("de-registered",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
