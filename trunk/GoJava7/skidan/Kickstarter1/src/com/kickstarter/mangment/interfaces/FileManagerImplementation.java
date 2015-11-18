package com.kickstarter.mangment.interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.kickstarter.db.ProjectDB;
import com.kickstarter.model.Project;

public class FileManagerImplementation implements ProjectManagerInterface {
	ProjectDB pdb = new ProjectDB();

	public Map<Integer, Project> getAll(String categoryTitle) {
		Map<Integer, Project> allProjects = new HashMap<>();
        try {
			allProjects = fileReader();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer, Project> categoryProjects = new HashMap<>();
		for (Project p : allProjects.values()) {
			if (p.getCategoryName().equals(categoryTitle)) {
				categoryProjects.put(p.getId(), p);
			}

		}
		return categoryProjects;

	}

	public Project getOne(String categoryTitle, int projectNumber) {
		Map<Integer, Project> requiredCategoryProjects = getAll(categoryTitle);
		Project p = requiredCategoryProjects.get(projectNumber);
		Map<Integer, Project> singleRequredProjectList = getAll(categoryTitle);
		singleRequredProjectList.put(0, p);
		return p;

	}

	public Map<Integer, Project> fileReader() throws FileNotFoundException, IOException {
		int i = 1;
		File file = new File("project.txt");
		Map<Integer, Project> allProjectList = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			try {
				String line;
				while ((line = br.readLine()) != null) {
					Project project = new Project();

					project.setId(new Integer((line)));
					project.setTitle(br.readLine());
					project.setDiscription(br.readLine());
					project.setDaysLeft((new Integer(br.readLine())));
					project.setRequiredSum(new Integer(br.readLine()));
					project.setGainedSum((new Integer(br.readLine())));
					project.setProjectHistory((br.readLine()));
					project.setVideoLink((br.readLine()));
					project.setQuestionSection(br.readLine());
					project.setCategoryName(br.readLine());

					allProjectList.put(i++, project);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return allProjectList;
		}

	}
}