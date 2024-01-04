package org.alok.smspostgres.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = Instructor.TABLE_NAME)
public class Instructor {

    public static final String TABLE_NAME = "INSTRUCTORSMS";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Instructor.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Instructor.SEQ_GEN_ALIAS, strategy = Instructor.SEQ_GEN_STRATEGY)
    private String instructorId;
    private String instructorName;
    private Date dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId_fk", nullable = true)
    private Course course;
}
