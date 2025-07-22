package com.github.theinfinity007.springhibernatebootcourse.restcrud.service.impl;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.dao.EmployeeDAO;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
