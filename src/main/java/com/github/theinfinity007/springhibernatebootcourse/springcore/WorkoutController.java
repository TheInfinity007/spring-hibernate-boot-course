package com.github.theinfinity007.springhibernatebootcourse.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach coach;


    // Constructor injection
    /*
    @Autowired
    WorkoutController(Coach coach) {
        this.coach = coach;
    }
    */

    // Setter injection, spring will call this method during initialization
    @Autowired
    public void setCoach(Coach coach){
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
