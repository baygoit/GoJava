package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}