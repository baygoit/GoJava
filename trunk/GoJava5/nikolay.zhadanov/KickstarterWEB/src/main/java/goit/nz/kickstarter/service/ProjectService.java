package goit.nz.kickstarter.service;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.domain.RewardOption;

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

	@Transactional(readOnly = true)
	public int getRewardAmount(long projectId, long rewardId) {
		Project project = getProject(projectId);
		int result = 0;
		int index = 0;
		int size = project.getRewardOptions().size();
		if (size > 0) {
			while (result == 0 && index < size) {
				RewardOption rewardOption = project.getRewardOptions().get(
						index);
				if (rewardOption.getId() == rewardId) {
					result = rewardOption.getAmount();
				}
				index++;
			}
		}
		return result;
	}

}
