package belskii.artem.kickstarter.dao.quote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import belskii.artem.kickstarter.dao.DBConnector;

public class QuoteDaoImplPsql implements QuoteDao {
	private Connection connection;

	public QuoteDaoImplPsql(String dbConnectionConfig) {
		connection = new DBConnector(dbConnectionConfig).getConnection();
	};

	private int getrandomId() {
		Random answer = new Random();
		int count = 0;
		String query = "SELECT COUNT(*) FROM QUOTES";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				count = new Integer(rs.getString("count"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answer.nextInt(count);
	}

	@Override
	public String getRandomQuote() {
		String quote = "";
		String query = "SELECT TEXT FROM QUOTES WHERE ID=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, this.getrandomId());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				quote = rs.getString("TEXT").toString();
			}
		} catch (SQLException e) {
			System.out.println("getRandomQuote");
			e.printStackTrace();
		}
		return quote;
	}

	@Override
	public void addQuote(String text) {
		String query = "INSERT INTO QUOTES (TEXT) VALUES (?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, text);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
