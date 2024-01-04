package com.example.mongo.entity.SchoolSchema;


import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = Course.TABLE_NAME)
public class Course {


    public static final String TABLE_NAME = "COURSE";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Employee.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Employee.SEQ_GEN_ALIAS, strategy = Employee.SEQ_GEN_STRATEGY)
    private String courseId;
    private String courseName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolId_fk",nullable = false)
    private School school;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId_fk", nullable = true)
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "std_course",
            joinColumns = @JoinColumn(name = "co_id", referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "st_id", referencedColumnName = "studentId"))
    List<Student> students;

}
