package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 20 minutes!!";
    }
}
