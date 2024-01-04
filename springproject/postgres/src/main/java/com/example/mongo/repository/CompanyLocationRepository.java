package com.example.mongo.repository;

import com.example.mongo.entity.CompanyLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyLocationRepository extends CrudRepository<CompanyLocation,String>{
}
