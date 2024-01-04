package com.example.mongo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {

    public static final String TABLE_NAME = "EMPLOYEE_TABLE";
    public static final String ID_COLUMN_NAME = "ID";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @Column(name = Employee.ID_COLUMN_NAME)
    @GeneratedValue(generator = Company.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Company.SEQ_GEN_ALIAS, strategy = Company.SEQ_GEN_STRATEGY)
    private String employeeId;
    private String firstName;
    private String lastName;
    private int age;
    private String department;
    private Date dob;
    private Date doj;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId_fk", nullable = false)
    private Company company;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankId_fk", nullable = false)
    private BankAccount bankAccount;

    @ManyToMany(mappedBy = "employees")
    private Set<CompanyLocation> companyLocations;
}
