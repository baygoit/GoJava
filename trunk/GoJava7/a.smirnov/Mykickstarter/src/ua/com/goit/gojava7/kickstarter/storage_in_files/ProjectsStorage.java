package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.AbstractFilesStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectsStorage extends AbstractFilesStorage<Project> {
	
//	private static final File FILE_FOR_TEST = new File("./resources/projects.csv");
	private static final File REWARDS_FILE = new File("./projects.csv");
	
	private static final int UNIQUE_ID = 0;
	private static final int CATEGORY_ID = 1;
	private static final int TITLE = 2;
	private static final int BRIEF_DESCRIPTION = 3;
	private static final int FULL_DESCRIPTION = 4;
	private static final int VIDEO_LINK = 5;
	private static final int REQUIREMENT_SUM = 6;
	private static final int COLLECTED_SUM = 7;
	private static final int DAYS_LEFT = 8;

	@Override
	public void add(Project element) {

		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(REWARDS_FILE, true);

			fileWriter.append(String.valueOf(element.getUniqueID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getCategoryID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getTitle());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getBriefDescription());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getFullDescription());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getVideoLink());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getRequiredSum()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getCollectedSum()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getDaysLeft()));
			fileWriter.append(NEW_LINE_SEPARATOR);

			fileWriter.flush();
			
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} finally {
	
			try {
				if (fileWriter != null ) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}
		
	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();
		String line = "";
		
		BufferedReader fileReader = null;
		
		try {
			
			fileReader = new BufferedReader(new FileReader(REWARDS_FILE));
			
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					
					Project project = new Project(tokens[TITLE], 
							tokens[BRIEF_DESCRIPTION], Integer.parseInt(tokens[REQUIREMENT_SUM]));
					
					project.setUniqueID(Integer.parseInt(tokens[UNIQUE_ID]));
					project.setCategoryID(Integer.parseInt(tokens[CATEGORY_ID]));
					project.addFullDescription(tokens[FULL_DESCRIPTION]);
					project.setVideoLink(tokens[VIDEO_LINK]);
					project.setCollectedSum(Integer.parseInt(tokens[COLLECTED_SUM]));
					project.setDaysLeft(Integer.parseInt(tokens[DAYS_LEFT]));
					
					projects.add(project);
				}
			}
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} finally {
	
			try {
				if (fileReader != null ) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}

		return projects;
	}
	
	public List<Project> getProjectsFromCategory(Category category) {
		List<Project> projects = getAll();
		List<Project> projectsFromSelectedCategory = new ArrayList<>();

		for (Project project : projects) {
			if (project.getCategoryID() == category.getUniqueID()) {
				projectsFromSelectedCategory.add(project);
			}
		}
		return projectsFromSelectedCategory;
	}
	
	@Override
	public void remove(Project element) {
		// TODO Auto-generated method stub
		
	}
}
