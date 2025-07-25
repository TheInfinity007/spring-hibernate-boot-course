package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Do 50 smash trials";
    }
}
