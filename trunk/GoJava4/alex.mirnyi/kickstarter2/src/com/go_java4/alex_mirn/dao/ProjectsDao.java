package com.go_java4.alex_mirn.dao;

import java.sql.SQLException;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;

public interface ProjectsDao {
	void add(Project project) throws SQLException;
	
	Project getProjectIndex(int index) throws SQLException;
	
	List<Project> getAllProjects() throws SQLException;

	int getProjectsSize() throws SQLException;
	
	List<Project> getProjectsInCategory(int index) throws SQLException;
}
