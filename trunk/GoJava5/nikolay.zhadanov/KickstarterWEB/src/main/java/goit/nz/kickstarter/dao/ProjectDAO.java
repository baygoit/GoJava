package goit.nz.kickstarter.dao;

import goit.nz.kickstarter.domain.Project;

import java.util.List;

public interface ProjectDAO {

	abstract List<Project> getProjects(long categoryId);

	abstract Project getProject(long id);

	abstract void updatePledgedAmount(long projectId, int pledgedAmount);

	abstract void addQuestion(long projectId, String question);

}