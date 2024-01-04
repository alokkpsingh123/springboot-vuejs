package com.example.demo.services.Impl;

import com.example.demo.services.MexicanFood;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class MexicanFoodImpl implements MexicanFood {

    public MexicanFoodImpl() {
        System.out.println("MexicanFoodImpl : No argument constructor");
    }

    public MexicanFoodImpl(int value){
        System.out.println("MexicanFoodImpl : Parameter constructor");
    }

    @PostConstruct
    public void postContructor(){
        System.out.println("MexicanFoodImpl : Post Constructor");
    }

    @Override
    public void displayMexicanFood() {
        System.out.println("Mexican Food : " + this.hashCode());

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("MexicanFoodImpl : Pre Destroy");
    }
}
