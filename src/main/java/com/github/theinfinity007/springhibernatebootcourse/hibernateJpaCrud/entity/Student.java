package com.github.theinfinity007.springhibernatebootcourse.hibernateJpaCrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstNma;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // Constructors
    public Student(){}

    public Student(String firstNma, String lastName, String email) {
        this.firstNma = firstNma;
        this.lastName = lastName;
        this.email = email;
    }


    // Getters/Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNma() {
        return firstNma;
    }

    public void setFirstNma(String firstNma) {
        this.firstNma = firstNma;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstNma='" + firstNma + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
