package com.github.theinfinity007.springhibernatebootcourse.springcore.Controller;

import com.github.theinfinity007.springhibernatebootcourse.springcore.Service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach coach;
    private Coach anotherCoach;

    /*
    // Constructor injection
    @Autowired
    public WorkoutController(Coach coach) {
        this.coach = coach;
    }
    */

    /*
    // Setter injection, spring will call this method during initialization
    @Autowired
    public void setCoach(Coach coach){
        this.coach = coach;
    }
    */

    /*
    // Qualifier usage
    @Autowired
    public WorkoutController(@Qualifier("tennisCoach") Coach coach) {
        this.coach = coach;
    }
    */

    /*
    // Instead of specifying a qualier, we can specify the @Primary annotation in the service and
    // spring will pick the primary automatically
    @Autowired
    public WorkoutController(Coach coach) {
        this.coach = coach;
    }
    */

    /*
    @Autowired
    public WorkoutController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.coach = coach;
    }
    */

    /*
    // @Scopes example, singleton and prototype
    @Autowired
    public WorkoutController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }
    */

    @Autowired
    public WorkoutController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/check")
    public String check(){
        // It will be true in case of coach is singleton scope, and in prototype scope, it will false
        return "Comparing beans: myCoach == anotherCoach, " + (coach == anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
