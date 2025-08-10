package com.github.theinfinity007.springhibernatebootcourse.restcrud.dao;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
