package com.github.theinfinity007.springhibernatebootcourse.springcore.config;

import com.github.theinfinity007.springhibernatebootcourse.springcore.Service.Coach;
import com.github.theinfinity007.springhibernatebootcourse.springcore.Service.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquaticCoach")
    public Coach swimCoach () {
        return new SwimCoach();
    }
}
