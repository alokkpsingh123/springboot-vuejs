package com.example.mongo.entity.SchoolSchema;


import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = School.TABLE_NAME)
public class School {

    public static final String TABLE_NAME = "SCHOOL";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @GeneratedValue(generator = Employee.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Employee.SEQ_GEN_ALIAS, strategy = Employee.SEQ_GEN_STRATEGY)
    private String schoolId;
    private String schoolName;
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId_fk", nullable = false)
    private City city ;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}
