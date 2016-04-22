package ua.nenya.dao;


public interface PaymentDao {
	
	long getPaymentSum(int projectId);
	int writePaymentInProject(int i, int amount);

}
