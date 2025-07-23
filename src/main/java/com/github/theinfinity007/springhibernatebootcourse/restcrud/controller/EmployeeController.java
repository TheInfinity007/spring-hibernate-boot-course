package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
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

    @PatchMapping("/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> payload) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        // throw exception if the payload contains the id
        if (payload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in the request body");
        }

        Employee patchedEmployee = apply(payload, employee);

        patchedEmployee.setId(employeeId);

         return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> payload, Employee employee){
        // convert the employee object to JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // convert the payload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(payload, ObjectNode.class);

        // merge the updates into the employee
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

}
