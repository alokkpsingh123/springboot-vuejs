package org.alok.smspostgres.controller;

import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.CourseDTO;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Code written by: Alok Singh on 26/11/23
 */

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * Register the course
     * @param courseDTO
     * @return
     */
    @PostMapping("/registerCourse")
    ResponseEntity<CourseDTO> registerCourse(@RequestBody CourseDTO courseDTO){
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return ResponseEntity.ok(courseService.registerCourse(course));
    }

    /**
     * Deleting of the course
     * @param corId not null
     * @return
     */
    @DeleteMapping("/deRegisterCourse/{corId}")
    ResponseEntity<Map<String,Boolean>> deRegisterCourse(@PathVariable String corId){
        courseService.deRegisterCourse(corId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("de-registered",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
