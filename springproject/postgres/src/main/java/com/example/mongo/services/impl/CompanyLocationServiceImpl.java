package com.example.mongo.services.impl;

import com.example.mongo.dto.CompanyLocationDto;
import com.example.mongo.entity.CompanyLocation;
import com.example.mongo.repository.CompanyLocationRepository;
import com.example.mongo.services.CompanyLocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyLocationServiceImpl implements CompanyLocationService {

    @Autowired
    private CompanyLocationRepository companyLocationRepository;

    @Override
    public CompanyLocation save(CompanyLocationDto companyLocationDto) {
        CompanyLocation companyLocation=new CompanyLocation();
        BeanUtils.copyProperties(companyLocationDto,companyLocation);
        return companyLocationRepository.save(companyLocation);
    }

    @Override
    public Iterable<CompanyLocation> getAll() {
        return companyLocationRepository.findAll();
    }

    @Override
    public Optional<CompanyLocation> findOne(String LocationId) {
        return companyLocationRepository.findById(LocationId);
    }
}
