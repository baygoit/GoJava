package ua.com.goit.gojava7.kickstarter.DAO.fileStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectFileStorage extends AbstractProjectStorage {
	private static int idGenerator;
	private File projectFile;
	List<String> projectLines;

	public ProjectFileStorage() {
		idGenerator = 0;
		projectFile = new File("./resources/projects.csv");
		ReadFile();
	}
	private void ReadFile() {
		try {
			projectLines = FileUtils.readLines(projectFile);
			if (projectLines.size() > 0) {
				String[] id = projectLines.get(projectLines.size() - 1).split(";");
				idGenerator = Integer.parseInt(id[0]);
			}
		} catch (IOException e) {
			System.err.println("CSV file reading error");
		}
	}

	@Override
	public List<Project> getAll() {
		ReadFile();
		List<Project> allProject = new ArrayList<>();
		for (String projectLine : projectLines) {
			String[] splittedProjectLine = projectLine.split(";");
			Project project = new Project();
			project.setIdProject(Integer.parseInt(splittedProjectLine[0]));
			project.setIdParentCategory(Integer.parseInt(splittedProjectLine[1]));
			project.setProjectName(splittedProjectLine[2]);
			project.setProjectShortDescription(splittedProjectLine[3]);
			project.setProjectDescription(splittedProjectLine[4]);
			project.setVideoUrl(splittedProjectLine[5]);
			project.setProjectCostNeed(Integer.parseInt(splittedProjectLine[6]));
			project.setDeadline(Integer.parseInt(splittedProjectLine[7]));

			allProject.add(project);

		}
		return allProject;
	}

	@Override
	public void add(Project project) {
		StringBuilder projectLine = new StringBuilder();
		projectLine.append(++idGenerator + ";");
		projectLine.append(project.getIdParentCategory() + ";");
		projectLine.append(project.getProjectName() + ";");
		projectLine.append(project.getProjectShortDescription() + ";");
		projectLine.append(project.getProjectDescription() + ";");
		projectLine.append(project.getVideoUrl() + ";");
		projectLine.append(project.getProjectCostNeed() + ";");
		projectLine.append(project.getDeadline() + ";");
		
		try {
			FileUtils.writeStringToFile(projectFile, projectLine.toString(), true);
		} catch (IOException e) {
			System.err.println("CSV file writting error");
		}
		
	}

	@Override
	public int getIdOfProject(int projectNumber) {
		return getAll().get(projectNumber).getIdProject();
	}

	@Override
	public Project getProjectById(int projectId) {
		for (Project project : getAll()) {
			if (project.getIdProject() == projectId) {
				return project;
			}
		}
		return null;
	}

	@Override
	public List<Project> getProjectsFromSelectedCategory(int idCategory) {
		List<Project> projectsInCategory = new ArrayList<>();
		for (Project project : getAll()) {
			if (project.getIdParentCategory() == idCategory) {
				projectsInCategory.add(project);
			}
		}
		return projectsInCategory;
	}

}
