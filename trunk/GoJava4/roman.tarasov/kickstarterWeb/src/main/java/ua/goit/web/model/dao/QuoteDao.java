package ua.goit.web.model.dao;

import org.springframework.stereotype.Component;


@Component
public interface QuoteDao {

	Quote getRandomQuote() throws KickstarterException;

}
