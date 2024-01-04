package com.example.demo.services.Impl;

import com.example.demo.services.IndianFood;
import com.example.demo.services.ItalianFood;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Scope prototype creates new instances
 * whenever new instance is required
 */

@Service
@Scope(value = "prototype")
public class ItalianFoodImpl implements IndianFood {

    public ItalianFoodImpl() {
        System.out.println("ItalianFoodImpl : No argument constructor");
    }

    public ItalianFoodImpl(int value){
        System.out.println("ItalianFoodImpl : Parameter constructor");
    }

    @PostConstruct
    public void postContructor(){
        System.out.println("ItalianFoodImpl : Post Constructor");
    }

//    @Override
//    public void displayItalianFood() {
//        System.out.println("Italian Food : " + this.hashCode());
//
//    }

    @Override
    public void displayIndianFood() {

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("ItalianFoodImpl : Pre Destroy");
    }
}
