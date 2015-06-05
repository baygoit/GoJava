package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.PaymentVariant;

public class PaymentsDAOImpl implements PaymentsDAO {

	private Connection connection;

	public PaymentsDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addPaymentVariant(int projectId, int amount, String description) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Payments (");
			sql.append("id_project, amount, description");
			sql.append(") ");
			sql.append("values(?,?,?)");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, projectId);
			statement.setInt(2, amount);
			statement.setString(3, description);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public void donate(int projectId, int amount) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("update Projects ");
			sql.append("set collect_amount = collect_amount + ? ");
			sql.append("where id = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, amount);
			statement.setInt(2, projectId);

			statement.execute();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public List<PaymentVariant> getPaymentVariants(int projectId) throws CannotGetDataException {
		List<PaymentVariant> result = new ArrayList<>();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, id_project, amount, description ");
			sql.append("from Payments ");
			sql.append("where id_project = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, projectId);

			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				result.add(getPaymentVariant(resultQuery));
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		return result;
	}

	@Override
	public PaymentVariant getPaymentVariant(int id, int projectId) throws CannotGetDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, id_project, amount, description ");
			sql.append("from Payments ");
			sql.append("where id = ? ");
			sql.append("AND ");
			sql.append("id_project = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			statement.setInt(2, projectId);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getPaymentVariant(resultQuery);
			} else {
				throw new CannotGetDataException("no existing data");
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
	}

	@Override
	public void createTablePayments() throws CannotCreateTableException {
		try {
			Statement statement = connection.createStatement();

			StringBuilder sql = new StringBuilder();

			sql.append("drop table IF EXISTS Payments; ");

			sql.append("create table Payments (");
			sql.append("id serial not null PRIMARY KEY, ");
			sql.append("id_project integer, ");
			sql.append("amount integer, ");
			sql.append("description varchar(255)");
			sql.append("); ");

			sql.append("alter table Payments ");
			sql.append("add FOREIGN KEY (id_project) ");
			sql.append("REFERENCES Projects(id); ");

			statement.execute(sql.toString());

		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	private PaymentVariant getPaymentVariant(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		int projectId = resultQuery.getInt("id_project");
		int amount = resultQuery.getInt("amount");
		String description = resultQuery.getString("description");

		return new PaymentVariant(id, projectId, amount, description);
	}
}
