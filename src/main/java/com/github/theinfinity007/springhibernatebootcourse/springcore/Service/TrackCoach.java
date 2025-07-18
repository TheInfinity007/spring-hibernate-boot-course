package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Run 4 hard 5k!";
    }
}
