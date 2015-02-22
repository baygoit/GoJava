package ua.home.kickstarter.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.factory.DaoFactory;
import ua.home.kickstarter.model.QuotationsDao;

public class QuotationsController {
	private DaoFactory daoFactory;

	public QuotationsController() {
		daoFactory = new DaoFactory();
	}

	public Quote getSpecificQuoteFromDB(int quoteId) {
		Quote quote = null;
		try (Connection con = daoFactory.getConnection()) {
			QuotationsDao quotationsDao = daoFactory.getQuotationsDao(con);
			quote = quotationsDao.getQuoteById(quoteId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quote;
	}

	public Quote getRandomQuote() {
		int i = new Random().nextInt(getQuotationsSize());
		return getSpecificQuoteFromDB(i + 1);
	}

	public String getQuoteContent(Quote quote) {
		StringBuilder quoteContent = new StringBuilder();
		quoteContent.append(quote.getQuote());
		return quoteContent.toString();
	}
	
	public int getQuotationsSize() {
		int size = -1;
		try (Connection con = daoFactory.getConnection()) {
			QuotationsDao quotationsDao = daoFactory.getQuotationsDao(con);
			size = (int) quotationsDao.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}
}
