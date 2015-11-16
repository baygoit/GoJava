package com.kickstarter.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.kickstarter.db.ProjectDB;
import com.kickstarter.model.Project;

public class ProjectFileManager {
	ProjectDB pdb = new ProjectDB();

	public Map<Integer, Project> getProjectsForCategory(String categoryTitle) throws FileNotFoundException, IOException {
		Map<Integer, Project> allProjects = fileReader();
		Map<Integer, Project> categoryProjects = new HashMap<>();
		for (Project p : allProjects.values()) {
			if (p.getCategoryName().equals(categoryTitle)) {
				categoryProjects.put(p.getId(), p);
			}
			
		}
		return categoryProjects;

	}

	public Project getProject(String categoryTitle, int projectNumber) throws FileNotFoundException, IOException {
		Map<Integer, Project> requiredCategoryProjects = getProjectsForCategory(categoryTitle);
		Project p = requiredCategoryProjects.get(projectNumber);
		Map<Integer, Project> singleRequredProjectList = getProjectsForCategory(categoryTitle);
		singleRequredProjectList.put(0, p);
		return p;

	}

	public Map<Integer, Project> fileReader() throws FileNotFoundException, IOException {
		int i = 1;
		File file = new File("project.txt");
		Map<Integer, Project> allProjectList = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			try {
				String section;
				// category = new Category(br.readLine());
				while ((section = br.readLine()) != null) {
					Project project = new Project();
					
					project.setTitle(br.readLine());
					project.setDiscription(br.readLine());
					project.setCategoryName(br.readLine());
					project.setDaysLeft((new Integer(br.readLine())));
					project.setGainedSum((new Integer(br.readLine())));					project.setId(Integer.parseInt((br.readLine())));
					project.setVideoLink((br.readLine()));
					project.setQuestionSection(br.readLine());
					project.setRequiredSum(new Integer(br.readLine()));
					project.setProjectHistory((br.readLine()));


					allProjectList.put(i++, project);
				}
	
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return allProjectList;
	}

}}