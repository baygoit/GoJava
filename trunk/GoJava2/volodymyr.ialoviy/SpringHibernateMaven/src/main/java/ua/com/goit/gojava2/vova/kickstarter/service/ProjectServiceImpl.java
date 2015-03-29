package ua.com.goit.gojava2.vova.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao dao;
	
	@Override
	public List<Project> findAllProjects(int id) {
		return dao.findAllProjects(id);
	}

	@Override
	public void saveProject(Project project) {
		dao.saveProject(project);
	}

	@Override
	public void deleteProjectById(int id) {
		dao.deleteProjectById(id);
	}

	@Override
	public Project getProgect(int id) {
		return dao.getProgect(id);
	}

	@Override
	public void addDonate(int amount, int id) {
		dao.addDonate(amount, id);		
	}

}
