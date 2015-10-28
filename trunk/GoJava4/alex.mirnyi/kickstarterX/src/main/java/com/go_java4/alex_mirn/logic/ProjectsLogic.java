package com.go_java4.alex_mirn.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.logic.Logic;
import com.go_java4.alex_mirn.view.pages.ProjectsPage;

public class ProjectsLogic implements Logic{
	private Dao repository;


	public ProjectsLogic(Dao repository) {
		this.repository = repository;
	}

	public Category getCategoriesIndex(int index1) throws SQLException {
		Category category = repository.getCategoriesIndex(index1);
		return category;
	}
	
	public List<Project> getProjectsInCategory(int index) throws SQLException {
		return repository.getProjectsInCategory(index);
	}
	public int getProjectsSize() throws SQLException {
		return repository.getProjectsSize();
	}
}
