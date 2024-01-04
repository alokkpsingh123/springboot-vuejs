package com.example.mongo.services;

import com.example.mongo.dto.CompanyDto;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Company;
import com.example.mongo.entity.Employee;

import java.util.Optional;

public interface ComanyService {

    Company save(CompanyDto companyDto);

    Iterable<Company> getAll();

    Optional<Company> findOne(String bankId);
}
