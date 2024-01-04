package com.example.mongo.entity.SchoolSchema;


import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = Instructor.TABLE_NAME)
public class Instructor {

    public static final String TABLE_NAME = "INSTRUCTOR";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Employee.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Employee.SEQ_GEN_ALIAS, strategy = Employee.SEQ_GEN_STRATEGY)
    private String instructorId;
    private String instructorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolId_fk", nullable = false)
    private School school;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId_fk", nullable = false)
    private Course course;
}
