package com.example.mongo.entity.SchoolSchema;

import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = Student.TABLE_NAME)
public class Student {

    public static final String TABLE_NAME = "STUDENT";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Employee.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Employee.SEQ_GEN_ALIAS, strategy = Employee.SEQ_GEN_STRATEGY)
    private String studentId;
    private String fname;
    private String lname;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolId_fk", nullable = false)
    private School school;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId_fk", nullable = false)
    private City city;

    @ManyToMany(fetch = FetchType.LAZY , mappedBy = "students")
    private List<Course> courses = new ArrayList<>();
}
