package kickstarter.model.dao.sub;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.model.entity.PaymentVariant;

public interface PaymentsDAO {
	/**
	 * add new PaymentVariant for project to DB
	 */
	void addPaymentVariant(int projectId, int amount, String description) throws DataBaseException, SQLException;

	/**
	 * add amount to collect_amount for project
	 */
	void donate(int projectId, int amount) throws DataBaseException, SQLException;

	/**
	 * return all PaymentVariants for project from DB
	 */
	List<PaymentVariant> getPaymentVariants(int projectId) throws DataBaseException, SQLException;

	/**
	 * return PaymentVariant for project from DB by id
	 */
	PaymentVariant getPaymentVariant(int id, int projectId) throws DataBaseException, SQLException;

	/**
	 * create table PaymentVariants in DB
	 */
	void createTablePayments() throws DataBaseException, SQLException;
}
