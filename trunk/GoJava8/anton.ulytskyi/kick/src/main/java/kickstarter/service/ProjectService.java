package kickstarter.service;

import java.util.List;

import kickstarter.dao.ProjectDAO;
import kickstarter.domain.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProjectService")
@Transactional
public class ProjectService {
	
	@Autowired
	protected ProjectDAO dao;

	public void setDao(ProjectDAO dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public List<Project> findProjectsOfCategory(String category) {
		return this.dao.findProjectsOfCategory(category);
	}

	@Transactional(readOnly = true)
	public Project openProject(int id) {
		return this.dao.openProject(id);
	}
}
