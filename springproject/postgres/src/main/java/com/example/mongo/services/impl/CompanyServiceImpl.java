package com.example.mongo.services.impl;

import com.example.mongo.dto.CompanyDto;
import com.example.mongo.entity.Company;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.CompanyRepository;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.services.ComanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements ComanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(CompanyDto companyDto) {

        Company company = new Company();
        BeanUtils.copyProperties(companyDto, company);
        return companyRepository.save(company);
    }

    @Override
    public Iterable<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findOne(String companyId) {
        return companyRepository.findById(companyId);
    }
}
