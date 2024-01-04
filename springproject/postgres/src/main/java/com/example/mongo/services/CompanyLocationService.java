package com.example.mongo.services;

import com.example.mongo.dto.CompanyLocationDto;
import com.example.mongo.entity.CompanyLocation;

import java.util.Optional;

public interface CompanyLocationService {
    CompanyLocation save(CompanyLocationDto companyLocationDto);

    Iterable<CompanyLocation> getAll();

    Optional<CompanyLocation> findOne(String LocationId);
}
