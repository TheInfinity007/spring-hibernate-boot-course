package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;


import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao.StudentDAO;
import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    StudentDAO studentDao;

    @Autowired
    StudentRestController(StudentDAO studentDao){
        this.studentDao = studentDao;
    }

    @GetMapping("")
    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentDao.findById(studentId);

        if (student == null) {
            throw new StudentNotFoundException("StudentNotFoundException", "Student id not found - " + studentId);
        }
        return student;
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        // create a student error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setErrorCode(ex.getErrorCode());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
