package ua.com.goit.gojava.kickstarter.payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava.kickstarter.data.Project;

public class PaymentSystem {

	private Connection c;

	public PaymentSystem(Connection c) {
		this.c = c;
	}

	public void pay(Project selectedProject, int amount) {

		selectedProject.getStatus().increaseAmount(amount);

	}

	public void pay(int amount, Project selected) throws SQLException {
		if (amount < 0) {
			throw new RuntimeException("wrong input");
		}
		Statement stmt = c.createStatement();
		String sql = "UPDATE project " + "SET collected = collected + '"
				+ amount + "' WHERE name = '" + selected.getName() + "';";
		stmt.executeUpdate(sql);
		stmt.close();
	}

}
