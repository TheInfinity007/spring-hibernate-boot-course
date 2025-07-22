package com.github.theinfinity007.springhibernatebootcourse.restcrud.service;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
