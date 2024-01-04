package com.example.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Table(name = Company.TABLE_NAME)
public class Company {

    public static final String  TABLE_NAME = "COMPANY";
    public static final String ID_COLUMN_NAME = "ID";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";


    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = Company.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Company.SEQ_GEN_ALIAS, strategy = Company.SEQ_GEN_STRATEGY)
    private String companyId;

    private String companyName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
