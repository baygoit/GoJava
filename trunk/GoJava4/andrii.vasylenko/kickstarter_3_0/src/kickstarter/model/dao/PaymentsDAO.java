package kickstarter.model.dao;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.PaymentVariant;

public interface PaymentsDAO {
	void addPaymentVariant(int projectId, int amount, String description) throws SQLException;

	void donate(int projectId, int amount) throws SQLException;

	List<PaymentVariant> getPaymentVariants(int projectId) throws SQLException;

	PaymentVariant getPaymentVariant(int id, int projectId) throws NoSuchDataException, SQLException;

	void createTablePayments() throws SQLException;
}
