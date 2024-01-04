package com.example.demo.services.Impl;

import com.example.demo.services.IndianFood;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class IndianFoodImpl implements IndianFood {

    public IndianFoodImpl() {
        System.out.println("IndianFoodImpl : No argument constructor");
    }

    public IndianFoodImpl(int value){
        System.out.println("IndianFoodImpl : Parameter constructor");
    }

    @PostConstruct
    public void postContructor(){
        System.out.println("IndianFoodImpl : Post Constructor");
    }

    @Override
    public void displayIndianFood() {
        System.out.println("Indian Food : " + this.hashCode());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("IndianFoodImpl : Pre Destroy");
    }
}
