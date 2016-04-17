package ua.nenya.dao;


public interface InvestmentDao {
	
	long getPaymentSum(int projectId);
	void writeIvestmentInProject(int i, int amount);

}
