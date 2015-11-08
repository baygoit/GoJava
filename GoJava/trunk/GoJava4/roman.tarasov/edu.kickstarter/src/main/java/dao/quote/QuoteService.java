package dao.quote;

import dao.pool.KickstarterException;

public interface QuoteService {

	Quote getRandomQuote() throws KickstarterException;

}
