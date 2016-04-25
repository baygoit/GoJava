package project;

import dao.DAOQuote;

public class KISSTest {
	public static void main(String[] args) {

		DAOQuote hibernate = new DAOQuote();
		String quote = hibernate.showQuote();
		System.out.println(quote);

	}
}
