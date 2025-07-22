package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}
