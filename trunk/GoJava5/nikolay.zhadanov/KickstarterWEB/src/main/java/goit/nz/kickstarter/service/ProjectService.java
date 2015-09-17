package goit.nz.kickstarter.service;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.domain.Project;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

public class ProjectService {
	private ProjectDAO projectDAO;

	public ProjectService(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Transactional(readOnly = true)
	public List<Project> getProjects(long categoryId) {
		return projectDAO.getProjects(categoryId);
	}

	@Transactional(readOnly = true)
	public Project getProject(long projectId) {
		Project project = projectDAO.getProject(projectId);
		// here we have to load lazy collections before leaving the
		// transactional scope
		Hibernate.initialize(project.getCategory());
		Hibernate.initialize(project.getEvents());
		Hibernate.initialize(project.getFaq());
		Hibernate.initialize(project.getRewardOptions());
		return project;
	}

	@Transactional(readOnly = false)
	public void pledgeAmount(long projectId, int amount) {
		projectDAO.updatePledgedAmount(projectId, amount);
	}

	@Transactional(readOnly = false)
	public void addQuestion(long projectId, String question) {
		projectDAO.addQuestion(projectId, question);
	}

}
