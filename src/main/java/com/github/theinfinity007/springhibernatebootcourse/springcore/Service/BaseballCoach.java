package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Do 100 pitches";
    }
}
