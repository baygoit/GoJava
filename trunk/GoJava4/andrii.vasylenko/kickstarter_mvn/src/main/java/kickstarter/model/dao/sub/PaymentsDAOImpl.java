package kickstarter.model.dao.sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.connection.ConnectionPool;
import kickstarter.model.entity.PaymentVariant;

public class PaymentsDAOImpl implements PaymentsDAO {
	private ConnectionPool connectionPool;

	public PaymentsDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addPaymentVariant(int projectId, int amount, String description) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getInsertQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, projectId);
			statement.setInt(2, amount);
			statement.setString(3, description);

			statement.executeUpdate();
		}
	}

	@Override
	public void donate(int projectId, int amount) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getDonateQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, amount);
			statement.setInt(2, projectId);

			statement.execute();
		}
	}

	@Override
	public List<PaymentVariant> getPaymentVariants(int projectId) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			List<PaymentVariant> result = new ArrayList<>();

			String sql = getMultiSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, projectId);

			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				result.add(getPaymentVariant(resultQuery));
			}

			return result;
		}
	}

	@Override
	public PaymentVariant getPaymentVariant(int id, int projectId) throws DataBaseException, SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setInt(2, projectId);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getPaymentVariant(resultQuery);
			} else {
				throw new DataBaseException(String.format("no PaymentVariant where id = %d", id));
			}
		}
	}

	@Override
	public void createTablePayments() throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = getCreateQuery();
			statement.execute(sql);
		}
	}

	private PaymentVariant getPaymentVariant(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		int projectId = resultQuery.getInt("id_project");
		int amount = resultQuery.getInt("amount");
		String description = resultQuery.getString("description");

		return new PaymentVariant(id, projectId, amount, description);
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Payments (");
		sql.append("id_project, amount, description");
		sql.append(") ");
		sql.append("values(?,?,?)");
		return sql.toString();
	}

	private String getDonateQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("update Projects ");
		sql.append("set collect_amount = collect_amount + ? ");
		sql.append("where id = ?");
		return sql.toString();
	}

	private String getMultiSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, id_project, amount, description ");
		sql.append("from Payments ");
		sql.append("where id_project = ?");
		return sql.toString();
	}

	private String getSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, id_project, amount, description ");
		sql.append("from Payments ");
		sql.append("where id = ? ");
		sql.append("AND ");
		sql.append("id_project = ?");
		return sql.toString();
	}

	private String getCreateQuery() {
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
		return sql.toString();
	}
}
