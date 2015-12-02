package com.kickstarter.dao;


import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
import com.kickstarter.dao.interfaces.ProjectDaoType;

public class ProjectDao extends ProjectDaoType {

	public ProjectDao() {
		
		projectDaoInterface = new DbProjectDaoImpl();
	}
}
