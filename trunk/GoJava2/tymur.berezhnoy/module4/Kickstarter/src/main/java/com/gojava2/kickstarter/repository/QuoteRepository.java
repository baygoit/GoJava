package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}