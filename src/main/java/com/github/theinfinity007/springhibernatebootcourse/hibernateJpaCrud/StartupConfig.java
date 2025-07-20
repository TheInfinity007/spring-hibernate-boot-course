package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {

    // This command link runner will be executed after the spring beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(String[] args) {
        return runner -> {
            System.out.println("Hello World");
        };
    }
}
