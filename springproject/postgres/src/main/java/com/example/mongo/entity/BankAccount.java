package com.example.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = BankAccount.TABLE_NAME)
public class BankAccount {
    public static final String TABLE_NAME = "BANK_ACCOUNT";
    public static final String ID_COLUMN_NAME = "ID";
    public static final String SEQ_GEN_ALIAS = "seq_gen_altas";
    public static final String SEQ_GEN_STRATEGY = "uuid2";

    @Id
    @Column(name = BankAccount.ID_COLUMN_NAME)
    @GeneratedValue(generator = Employee.SEQ_GEN_ALIAS)
    @GenericGenerator(name = Employee.SEQ_GEN_ALIAS, strategy = Employee.SEQ_GEN_STRATEGY)
    private String id;

    private String bankName;

    private String accountNumber;
    @OneToOne(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee employee;
}