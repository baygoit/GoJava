package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}
