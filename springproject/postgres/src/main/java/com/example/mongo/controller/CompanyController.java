package com.example.mongo.controller;


import com.example.mongo.dto.BankAccountDto;
import com.example.mongo.dto.CompanyDto;
import com.example.mongo.dto.CompanyResponseDto;
import com.example.mongo.dto.EmployeeResponseDto;
import com.example.mongo.entity.Company;
import com.example.mongo.entity.Employee;
import com.example.mongo.services.ComanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    ComanyService comanyService;

    @PostMapping
    public Company save(@RequestBody CompanyDto companyDto){
        return comanyService.save(companyDto);
    }

    @GetMapping("/findAll")
    public List<CompanyResponseDto> findAll(){

        Iterable<Company> companies =  comanyService.getAll();
        List<CompanyResponseDto> responseDtoList = new ArrayList<>();
        for( Company company : companies){
            CompanyResponseDto companyResponseDto = new CompanyResponseDto();
            BeanUtils.copyProperties(company, companyResponseDto);
            responseDtoList.add(companyResponseDto);
        }

        return responseDtoList;
    }
}
