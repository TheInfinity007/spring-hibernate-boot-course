package com.github.theinfinity007.springhibernatebootcourse.restcrud.service;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
