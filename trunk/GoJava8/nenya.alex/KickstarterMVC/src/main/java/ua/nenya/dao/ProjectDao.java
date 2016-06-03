package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

public interface ProjectDao {

	List<Project> getProjectsByCategoryId(Long id);
	Project getProjectByProjectId(Long proId);
	List<Reward> getRewardsByProjectId(Long projectId);
	List<Project> getProjects();
	Project deleteProjectByProjectId(Long projectId);
	Project saveProject(Project project);
	long getPaymentSum(Long projectId);
	boolean isProjectExistById(Long projectId);
	boolean isProjectExistByName(String projectName);
}
