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
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initDemoDB() {
		String dropTables = "DROP TABLE IF EXISTS QUOTES;";
		try (PreparedStatement statement = connection.prepareStatement(dropTables)) {
			connection.setAutoCommit(true);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String createQuote = "CREATE TABLE QUOTES (ID serial, TEXT varchar(500));";
		try (PreparedStatement quoteStatement = connection.prepareStatement(createQuote)) {
			connection.setAutoCommit(true);
			quoteStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		this.addQuote("Things work out best for those who make the best of how things work out.");
		this.addQuote("All our dreams can come true if we have the courage to pursue them.");
		this.addQuote("Success is walking from failure to failure with no loss of enthusiasm.");
		this.addQuote("Try not to become a person of success, but rather try to become a person of value.");
		this.addQuote("Don't be afraid to give up the good to go for the great.");

	}

}
