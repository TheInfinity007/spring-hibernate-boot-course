package com.github.theinfinity007.springhibernatebootcourse.springcore.Service;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
