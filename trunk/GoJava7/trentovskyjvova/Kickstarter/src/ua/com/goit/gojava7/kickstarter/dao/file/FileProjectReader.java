package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectReader;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.exception.ProjectReadException;

public class FileProjectReader implements ProjectReader {
	private static final String CSV_SPLIT_BY = ";";
	private File projectsFile;

	public FileProjectReader(File projectsFile) {
		this.projectsFile = projectsFile;
	}

	@Override
	public List<Project> readProjects() {
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
				if (loadedProject.length < 10) {
					throw new ProjectReadException(
							"Wrong projects.csv format.");
				} else if (loadedProject[0] == "") {
					throw new ProjectReadException(
							"Wrong projects.csv format. Cannot find project id");
				} else if (loadedProject[1] == "") {
					throw new ProjectReadException(
							"Wrong projects.csv format. Cannot find project name");
				} else if (loadedProject[2] == "") {
					throw new ProjectReadException(
							"Wrong projects.csv format. Cannot find category id of project");
				}
				projectId = Integer.parseInt(loadedProject[0]);
				projectName = loadedProject[1];
				project = new Project(projectName, projectId);
				project.setCategoryId(Integer.parseInt(loadedProject[2]));
				project.setFunded(Integer.parseInt(loadedProject[3]));
				project.setDaysToGo(Integer.parseInt(loadedProject[4]));
				project.setPledged(Integer.parseInt(loadedProject[5]));
				project.setDescription(loadedProject[6]);
				project.setOwner(loadedProject[7]);
				project.setGoal(Integer.parseInt(loadedProject[8]));
				project.setLinkVideo(loadedProject[9]);
				
				projects.add(project);
			}
		} catch (IOException e) {
			throw new ProjectReadException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + projectsFile);
				}
			}
		}

		if (projects.isEmpty()) {
			throw new ProjectReadException("There is not projects in file");
		}

		return projects;
	}

}
