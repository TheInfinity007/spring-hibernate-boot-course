package com.github.theinfinity007.springhibernatebootcourse.restcrud.service.impl;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.dao.EmployeeRepository;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import com.github.theinfinity007.springhibernatebootcourse.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class EmployeeServiceJpaImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceJpaImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }

        throw new RuntimeException("Did not find employee with id: " + id);
    }

    @Override
//    @Transactional -> JPA repository provides it
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

