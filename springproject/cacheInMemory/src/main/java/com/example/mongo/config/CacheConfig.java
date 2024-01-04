package com.example.mongo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();
        List<String> data = new ArrayList<>();
        data.add("employees");
        mgr.setCacheNames(data);
        return mgr;
    }
}
