package ua.nenya.service;

public interface ProjectService {

	boolean isProjectExistById(Long projectId);

	boolean isProjectExistByName(String name);
	
	long getPaymentSum(Long projectId);
}
