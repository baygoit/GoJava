package com.ivanpozharskyi.kickstarter.entity;

import java.sql.SQLException;
import java.util.List;

public interface Projects {
	
	void addProject(String name, int moneyGot, int moneyNeed
			, int daysLeft, int categoryId) throws SQLException;
	Project getProject(int id) throws SQLException;
	int getSize() throws SQLException;
	List<Project> getProjectsInCategory(Category category) throws SQLException;
}
