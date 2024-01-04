package org.alok.smspostgres.repository;

import org.alok.smspostgres.dto.CourseCountByStudentDTO;
import org.alok.smspostgres.dto.CourseDetailsDTO;
import org.alok.smspostgres.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    @Query("SELECT NEW org.alok.smspostgres.dto.CourseCountByStudentDTO(c.courseId, c.courseName, COUNT(s)) " +
            "FROM Course c " +
            "LEFT JOIN c.students s " +
            "GROUP BY c.courseId, c.courseName")
    List<CourseCountByStudentDTO> getStudentCountEnrolledCourse();

    @Query("SELECT NEW org.alok.smspostgres.dto.CourseDetailsDTO(s, c, i) " +
            "FROM Course c " +
            "JOIN c.students s " +
            "LEFT JOIN c.instructor i " +
            "WHERE c.courseId = :courseId")
    List<CourseDetailsDTO> getDetailsByCourseId(@Param("courseId") String courseId);


}
