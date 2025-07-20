package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud;

import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao.StudentDAO;
import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {

    // This command link runner will be executed after the spring beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

//            createMultipleStudents(studentDAO);

            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Paul", "Walker", "pwalker@yopmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        int id = newStudent.getId();
        // display id of the saved student
        System.out.println("Saved student. Generated id: " + id);

        System.out.println("Retrieving student with id: " + id);
        Student student = studentDAO.findById(id);

        // display
        System.out.println("Found the student: " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating three student objects ...");
        Student newStudent1 = new Student("Vin", "Diesel", "vdiesel@yopmail.com");
        Student newStudent2 = new Student("Michelle", "Rodriguez", "mrodriguez@yopmail.com");
        Student newStudent3 = new Student("Jordana", "Brewster", "jbrewster@yopmail.com");

        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);

        System.out.println("Saved student.. ");
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Paul", "Walker", "pwalker@yopmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + newStudent.getId());
    }
}
