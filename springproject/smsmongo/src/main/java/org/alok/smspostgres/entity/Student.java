package org.alok.smspostgres.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = Student.TABLE_NAME)
public class Student {

    public static final String TABLE_NAME = "STUDENT";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Student.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Student.SEQ_GEN_ALIAS, strategy = Student.SEQ_GEN_STRATEGY)
    private String studentId;
    private String studentName;
    private Date dateOfBirth;


    @ManyToMany(fetch = FetchType.LAZY , mappedBy = "students")
    private List<Course> courses = new ArrayList<>();
}
