package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Project;

public interface ProjectDao {

	List<Project> getProjectsByCategoryId(int id);
	Project getProjectByProjectId(int proId);
	boolean isProjectExist(int proId);
	void getProjectPayments(Project project);
	long getPaymentSum(Project project);
}
