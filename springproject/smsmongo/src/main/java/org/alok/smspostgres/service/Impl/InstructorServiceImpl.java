package org.alok.smspostgres.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.alok.smspostgres.dto.InstructorCourseDTO;
import org.alok.smspostgres.dto.InstructorDTO;
import org.alok.smspostgres.dto.InstructorResposeDTO;
import org.alok.smspostgres.entity.Course;
import org.alok.smspostgres.entity.Instructor;
import org.alok.smspostgres.entity.Student;
import org.alok.smspostgres.repository.CourseRepository;
import org.alok.smspostgres.repository.InstructorRepository;
import org.alok.smspostgres.repository.StudentRepository;
import org.alok.smspostgres.service.InstructorService;
import org.alok.smspostgres.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository instructorRepository;
    
    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public InstructorResposeDTO registerInstructor(Instructor instructor) {

        InstructorResposeDTO instructorDTO = new InstructorResposeDTO();
        instructor = instructorRepository.save(instructor);
        BeanUtils.copyProperties(instructor, instructorDTO);
        return instructorDTO;
    }

    @Override
    public void deRegisterInstructor(String instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    public InstructorResposeDTO updateInstructorDetails(Instructor instructor) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructor.getInstructorId());
        if(instructorOptional.isPresent()){
            InstructorResposeDTO instructorDTO = new InstructorResposeDTO();
            instructor = instructorRepository.save(instructor);
            BeanUtils.copyProperties(instructor,instructorDTO);
            return instructorDTO;
        }else {
            log.error("Student does not exist");
            return null;
        }
    }

    @Override
    public void enrollForCourse(String instructorId, String courseId) {
        registrationService.registerInstructorForCourse(instructorId, courseId);
    }

    @Override
    public void withdrawCourse(String instructorId, String courseId) {
        registrationService.withdrawInstructorFromCourse(instructorId, courseId);

    }

    @Override
    public void courseUpdation(String studentId, String courseStatus , String courseId) {
      Optional<Student> studentOptional = studentRepository.findById(studentId);
      Optional<Course> courseOptional = courseRepository.findById(courseId);

      if(studentOptional.isPresent() && courseOptional.isPresent()){
          Student student = studentOptional.get();
          List<Course> courseList = student.getCourses();

          for(Course course: courseList){
              if (course.getCourseId().equals(courseId)){
                  course.setCourseProgress(courseStatus);
              }
          }

          student.setCourses(courseList);
          studentRepository.save(student);
      }else{
          log.error("Either student or course does not exist");
      }
    }

    @Override
    public List<InstructorCourseDTO> getInstructorDetailsForCourses() {
        return instructorRepository.getInstructorDetailsForCourses();
    }

    @Override
    public long getInstructorCount() {
        return instructorRepository.getInstructorCount();
    }


}
