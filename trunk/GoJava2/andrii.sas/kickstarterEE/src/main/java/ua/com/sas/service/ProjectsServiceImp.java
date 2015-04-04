package ua.com.sas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.Project;

@Service
@Transactional
public class ProjectsServiceImp implements ProjectsService{
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	@Override
	public Project getCurrent(int id) {
		return projectsDAO.get(id);
	}
	
}
