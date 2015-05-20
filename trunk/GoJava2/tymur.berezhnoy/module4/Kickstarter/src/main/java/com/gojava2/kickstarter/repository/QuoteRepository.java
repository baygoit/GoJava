package com.gojava2.kickstarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gojava2.kickstarter.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
//	@Query("select q from Quote q order by rand()")
	@Query(value = "SELECT * FROM quotes q ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
	Quote getRandomQuote();
}