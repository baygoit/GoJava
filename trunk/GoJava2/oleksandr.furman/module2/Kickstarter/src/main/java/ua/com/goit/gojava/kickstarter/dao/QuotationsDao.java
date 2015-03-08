package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Quote;

@Component
public class QuotationsDao extends AbstractDAO {

	public Quote getRandomQuote() {
		Random random = new Random();
		int index = random.nextInt((int) size());
		Quote quote = new Quote();
		String sql = "SELECT * FROM quotations WHERE id = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, index + 1);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				quote.setQuote(rs.getString("quote"));
			}
			return quote;
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}

	public long size() {
		long count = 0;
		String sql = "SELECT COUNT(*) AS count FROM quotations";
		try (Connection connection = getConnection()) {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				count = rs.getLong("count");
			}
			return count;
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}
}
