package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Run 4 hard 5k!";
    }
}
