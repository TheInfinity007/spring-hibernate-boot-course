package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud;

import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao.StudentDAO;
import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StartupConfig {

    // This command link runner will be executed after the spring beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

//            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("\nExecuting deleteAllStudent");

        System.out.println("Deleting all students");
        int numRecordsDeleted = studentDAO.deleteAll();

        System.out.println("Deleted Records Count: " + numRecordsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("\nExecuting deleteStudent");

        Student student = createStudent(studentDAO);
        System.out.println("Student before delete: " + student);

        System.out.println("Deleting the student with id: " + student.getId());

        studentDAO.delete(student.getId());

        System.out.println("Student deleted");
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("\nExecuting updateStudent");

        Student student = createStudent(studentDAO);
        System.out.println("Student before update: " + student);

        System.out.println("Updating the student");

        student.setFirstName("Dome");
        Student updatedStudent = studentDAO.update(student);

        System.out.println("Updated student: " + updatedStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        System.out.println("\nExecuting queryForStudentsByLastName");
        List<Student> res = studentDAO.findByLastName("walker");
        for(Student student: res){
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        System.out.println("\nExecuting queryForStudents");
        List<Student> res = studentDAO.findAll();
        for(Student student: res){
            System.out.println(student);
        }
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

    private Student createStudent(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Paul", "Walker", "pwalker@yopmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + newStudent.getId());

        return newStudent;
    }
}
