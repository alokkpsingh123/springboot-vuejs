package com.example.demo.controller;

import com.example.demo.services.IndianFood;
import com.example.demo.services.ItalianFood;
import com.example.demo.services.MexicanFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * Controller class
 */

@Controller
public class FoodController {

    /**
     * There ways to create the bean
     *   1. using field injection
     *   2. using constructor injection
     *   3. using setter function
     */

    /**
     * Getting reference of the services using autowired.
     */

//    @Autowired
//    IndianFood indianFood;
//
//    @Autowired
//    ItalianFood italianFood;


    /**
     * If Two classes are implementing
     * the same interface specify it
     * using Qualifier
     */

    @Autowired
    @Qualifier("indianFoodImpl")
    IndianFood indianFood;

    @Autowired
    @Qualifier("italianFoodImpl")
    IndianFood italianFood;

    /**
     * For demonstrating the scope(prototype)
     */

//    @Autowired
//    ItalianFood italianFood1;

    MexicanFood mexicanFood;

    public FoodController(){
        System.out.println("FoodController : No argument constructor");
    }


    public FoodController(MexicanFood mexicanFood){
        System.out.println("FoodController : Argument Constructor using constructor injection");
    }

    @Autowired
    public void setMexicanFood(MexicanFood mexicanFood){
        System.out.println("MexicanFood : Using setter function" );
        this.mexicanFood = mexicanFood;
    }

    @PostConstruct
    public void display(){
        indianFood.displayIndianFood();
//        italianFood.displayItalianFood();
        mexicanFood.displayMexicanFood();
    }
}
