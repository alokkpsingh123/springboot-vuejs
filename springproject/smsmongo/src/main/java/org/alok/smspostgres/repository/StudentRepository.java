package org.alok.smspostgres.repository;

import org.alok.smspostgres.dto.StudentCourseDTO;
import org.alok.smspostgres.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    @Query("SELECT COUNT(s) FROM Student s")
    long getStudentCount();

    @Query("SELECT NEW org.alok.smspostgres.dto.StudentCourseDTO(s.studentId, s.studentName, c.courseName, c.courseProgress, s.dateOfBirth) " +
            "FROM Student s " +
            "JOIN s.courses c " +
            "WHERE c.courseProgress = :courseStatus")
    List<StudentCourseDTO> getStudentsByCourseStatus(@Param("courseStatus") String courseStatus);
}
