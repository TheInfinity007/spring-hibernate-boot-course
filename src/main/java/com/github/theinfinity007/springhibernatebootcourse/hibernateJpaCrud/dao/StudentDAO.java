package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao;

import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    Student update(Student student);

}

