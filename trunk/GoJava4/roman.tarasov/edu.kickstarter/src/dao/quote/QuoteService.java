package dao.quote;

import database.KickstarterException;

public interface QuoteService {

	Quote getRandomQuote() throws KickstarterException;

}
