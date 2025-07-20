package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.dao;

import com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Entity manager
    EntityManager entityManager;

    @Autowired
    StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
