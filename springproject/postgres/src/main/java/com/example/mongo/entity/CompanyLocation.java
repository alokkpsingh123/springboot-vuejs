package com.example.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = CompanyLocation.TABLE_NAME)
public class CompanyLocation {

    public static final String  TABLE_NAME = "COMPANY_LOCATION";
    public static final String ID_COLUMN_NAME = "ID";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";


    @Id
    @GeneratedValue(generator = Company.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Company.SEQ_GEN_ALIAS, strategy = Company.SEQ_GEN_STRATEGY)
    private String locationId;

    private String city;

    @ManyToMany
    @JoinTable(
          name = "emp_loc",
          joinColumns = @JoinColumn(name = "lid", referencedColumnName = "locationId"),
          inverseJoinColumns = @JoinColumn(name = "eid", referencedColumnName = "id"))
    List<Employee> employees;

}
