package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuotesFromDB implements Quotes{
	
	@Override
	public String getQuote() {
		StringBuilder s = new StringBuilder();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
				 int countQuote = 0;
				 ResultSet result1 = statement.executeQuery("SELECT COUNT(*) FROM quotes;");
				 while (result1.next()) {
					 countQuote = result1.getInt("count");
				 }
				 int random = random(countQuote);
				 ResultSet result = statement.executeQuery("SELECT * FROM quotes WHERE id_quote =" + random);
				 while (result.next()) {
					 s.append(result.getString("quote")).toString();
				 }
			}
		};
        temp.templateWorkWithDB();
		return s.toString();
	}

	@Override
	public int random(int countQuote) {
		return (int) (Math.random() * countQuote + 0.5);
	}

}
