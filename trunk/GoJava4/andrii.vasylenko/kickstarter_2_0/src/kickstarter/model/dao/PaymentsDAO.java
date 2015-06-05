package kickstarter.model.dao;

import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.PaymentVariant;

public interface PaymentsDAO {
	void addPaymentVariant(int projectId, int amount, String description) throws CannotAddDataException;

	void donate(int projectId, int amount) throws CannotAddDataException;

	List<PaymentVariant> getPaymentVariants(int projectId) throws CannotGetDataException;

	PaymentVariant getPaymentVariant(int id, int projectId) throws CannotGetDataException;

	void createTablePayments() throws CannotCreateTableException;
}
