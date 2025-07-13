package com.github.theinfinity007.springhibernatebootcourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateBootCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateBootCourseApplication.class, args);
		System.out.println("Application started");
	}

	@Bean
	public CommandLineRunner commandLineRunnerCustom(ApplicationContext ctx){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				// Beans
				String[] beans = ctx.getBeanDefinitionNames();

				for(String bean: beans){
//					System.out.println(bean);
				}

				System.out.println("Total Beans = " + beans.length);
			}
		};
	}
}
