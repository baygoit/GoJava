package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class FileProjectReader implements ProjectDao {
	private static final String CSV_SPLIT_BY = ";";
	private File projectsFile;
	
	public FileProjectReader(File projectsFile) {
		this.projectsFile = projectsFile;
	}

	@Override
	public List<Project> getProjects(int categoryId) {
		List<Project> projects = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream projectsFileSteam = new FileInputStream(projectsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					projectsFileSteam));

			String line = null;
			int projectId = 0;
			String projectName = null;
			Project project;
			while (null != (line = fileReader.readLine())) {
				String[] loadedProject = line.split(CSV_SPLIT_BY);
				if (loadedProject.length < 8) {
					throw new WrongFileFormatException(
							"Wrong projects.csv format.");
				} else if (loadedProject[0] == "") {
					throw new WrongFileFormatException(
							"Wrong projects.csv format. Cannot find project id");
				} else if (loadedProject[1] == "") {
					throw new WrongFileFormatException(
							"Wrong projects.csv format. Cannot find project name");
				} else if (loadedProject[2] == "") {
					throw new WrongFileFormatException(
							"Wrong projects.csv format. Cannot find category id of project");
				}
				
				if (categoryId != 0
						&& Integer.parseInt(loadedProject[2]) != categoryId) {
					continue;
				}
				
				projectId = Integer.parseInt(loadedProject[0]);
				projectName = loadedProject[1];
				project = new Project(projectName, projectId);
				project.setCategoryId(categoryId);
				project.setDaysToGo(Integer.parseInt(loadedProject[3]));
				project.setDescription(loadedProject[4]);
				project.setOwner(loadedProject[5]);
				project.setGoal(Integer.parseInt(loadedProject[6]));
				project.setLinkVideo(loadedProject[7]);
				
				projects.add(project);
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + projectsFile);
				}
			}
		}

		/*if (projects.isEmpty()) {
			throw new WrongFileFormatException("There is not projects in file");
		}*/

		return projects;
	}

	@Override
	public Project getProject(int id) {
		List<Project> projects = getProjects(0);
		Project result = null;
		for (Project project : projects) {
			if(project.getId() == id){
				result = project;
				break;
			}
		}
		return result;
	}

	@Override
	public int size() {
		List<Project> projects = getProjects(0);
		return projects.size();
	}

}
