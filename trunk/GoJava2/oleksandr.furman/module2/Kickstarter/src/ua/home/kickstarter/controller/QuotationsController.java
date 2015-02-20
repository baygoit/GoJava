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

	public String getRandomQuoteToView() {
		StringBuilder quote = new StringBuilder();
		int i = new Random().nextInt(getQuotationsSize());
		quote.append(getSpecificQuoteFromDB(i + 1).getQuote());
		return quote.toString();
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
