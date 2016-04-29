package ua.nenya.dao;

import ua.nenya.domain.Payment;

public interface PaymentDao {
	
	int writePaymentInProject(Payment payment);

}
