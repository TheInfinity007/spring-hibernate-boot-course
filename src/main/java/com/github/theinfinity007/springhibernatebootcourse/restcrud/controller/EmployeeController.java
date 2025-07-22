package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.dao.EmployeeDAO;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
