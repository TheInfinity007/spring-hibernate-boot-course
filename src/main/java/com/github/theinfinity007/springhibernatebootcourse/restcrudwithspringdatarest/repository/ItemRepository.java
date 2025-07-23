package com.github.theinfinity007.springhibernatebootcourse.restcrudwithspringdatarest.repository;

import com.github.theinfinity007.springhibernatebootcourse.restcrudwithspringdatarest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
