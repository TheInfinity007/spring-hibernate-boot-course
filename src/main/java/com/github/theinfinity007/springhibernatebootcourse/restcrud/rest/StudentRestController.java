package com.github.theinfinity007.springhibernatebootcourse.restcrud.rest;


import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao.StudentDAO;
import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    StudentDAO studentDao;

    @Autowired
    StudentRestController(StudentDAO studentDao){
        this.studentDao = studentDao;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentDao.findAll();
    }
}
