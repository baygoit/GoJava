package ua.nenya.dao;

import ua.nenya.domain.Payment;

public interface PaymentDao {
	
	Payment writePaymentInProject(Payment payment);

}
