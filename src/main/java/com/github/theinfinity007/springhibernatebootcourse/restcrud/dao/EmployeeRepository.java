package com.github.theinfinity007.springhibernatebootcourse.restcrud.dao;

import com.github.theinfinity007.springhibernatebootcourse.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
