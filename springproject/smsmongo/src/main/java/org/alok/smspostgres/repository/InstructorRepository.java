package org.alok.smspostgres.repository;

import org.alok.smspostgres.dto.InstructorCourseDTO;
import org.alok.smspostgres.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InstructorRepository extends CrudRepository<Instructor, String> {

    @Query("SELECT NEW org.alok.smspostgres.dto.InstructorCourseDTO(c.courseId, c.courseName, i.instructorId, i.instructorName) " +
            "FROM Course c " +
            "LEFT JOIN c.instructor i")
    List<InstructorCourseDTO> getInstructorDetailsForCourses();

    @Query("SELECT COUNT(i) FROM Instructor i")
    long getInstructorCount();
}
