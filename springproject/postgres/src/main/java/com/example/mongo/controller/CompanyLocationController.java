package com.example.mongo.controller;

import com.example.mongo.dto.CompanyLocationDto;
import com.example.mongo.entity.CompanyLocation;
import com.example.mongo.services.CompanyLocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companylocation")
public class CompanyLocationController {
    @Autowired
    CompanyLocationService companyLocationService;

    @PostMapping
    public CompanyLocation save(@RequestBody CompanyLocationDto companyLocationDto){
        return companyLocationService.save(companyLocationDto);
    }

    @GetMapping("/findAll")
    public List<CompanyLocationDto> findAll(){

        Iterable<CompanyLocation> companies =  companyLocationService.getAll();
        List<CompanyLocationDto> responseDtoList = new ArrayList<>();
        for( CompanyLocation company : companies){
            CompanyLocationDto companyResponseDto = new CompanyLocationDto();
            BeanUtils.copyProperties(company, companyResponseDto);
            responseDtoList.add(companyResponseDto);
        }

        return responseDtoList;
    }

}
