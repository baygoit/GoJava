package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.FAQ;

public interface FaqRepository extends JpaRepository<FAQ, Integer> {

}