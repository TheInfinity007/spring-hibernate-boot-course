package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        return employee;
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);  // setting id to 0 allow the dao to insert the entity

        Employee createdEmployee = employeeService.save(employee);
        return createdEmployee;
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        employee.setId(employeeId);

        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

}
