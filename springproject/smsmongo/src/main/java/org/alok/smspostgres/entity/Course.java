package org.alok.smspostgres.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
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
    @GeneratedValue(generator = Course.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Course.SEQ_GEN_ALIAS, strategy = Course.SEQ_GEN_STRATEGY)
    private String courseId;
    private String courseName;
    private Double courseFee;
    private String courseProgress;

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
