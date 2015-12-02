package ua.com.goit.gojava7.kikstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class ProjectDaoFile implements ProjectDao {

	private static final File STORAGE_FILE = new File("./resources/projects.csv");
	private static final int PROJECT_ID = 0;
	private static final int CATEGORY_ID = 1;
	private static final int NAME = 2;
	private static final int DESCRIPTION = 3;
	private static final int VIDEO_LINK = 4;
	private static final int REQUIREMENT_SUM = 5;
	private static final int COLLECTED_SUM = 6;
	private static final int DAYS_LEFT = 7;
	private static final String SEMICOLON = ";";
	private FileWriter fileWriter = null;;

	@Override
	public void add(Project project) {

		try {
			fileWriter = new FileWriter(STORAGE_FILE, true);

			fileWriter.append(String.valueOf(project.getUniqueID()));
			fileWriter.append(SEMICOLON);
			fileWriter.append(String.valueOf(project.getCategoryID()));
			fileWriter.append(SEMICOLON);
			fileWriter.append(project.getName());
			fileWriter.append(SEMICOLON);
			fileWriter.append(project.getDescription());
			fileWriter.append(SEMICOLON);
			fileWriter.append(project.getUrl());
			fileWriter.append(SEMICOLON);
			fileWriter.append(String.valueOf(project.getNecessaryAmount()));
			fileWriter.append(SEMICOLON);
			fileWriter.append(String.valueOf(project.getAmountCollected()));
			fileWriter.append(SEMICOLON);
			fileWriter.append(String.valueOf(project.getEndOfDays()));
			fileWriter.append("\n");

			fileWriter.flush();
		} catch (Exception e) {
			System.out.println("CSV file writting error");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader");
			}
		}
	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();
		String line = "";
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(STORAGE_FILE));

			while ((line = fileReader.readLine()) != null) {
				String[] splitString = line.split(SEMICOLON);
				if (splitString.length > 0) {
					Project project = new Project();

					project.setUniqueID(Integer.parseInt(splitString[PROJECT_ID]));
					project.setCategoryID(Integer.parseInt(splitString[CATEGORY_ID]));
					project.setName(splitString[NAME]);
					project.setDescription(splitString[DESCRIPTION]);
					project.setUrl(splitString[VIDEO_LINK]);
					project.setNecessaryAmount(Integer.parseInt(splitString[REQUIREMENT_SUM]));
					project.setAmountCollected(Integer.parseInt(splitString[COLLECTED_SUM]));
					project.setEndOfDays(Integer.parseInt(splitString[DAYS_LEFT]));

					projects.add(project);
				}
			}
		} catch (Exception e) {
			System.out.println("Error in Read CSV file.");
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}

		return projects;
	}

	@Override
	public List<Project> getProjectsFromCategory(Category category) {
		List<Project> projects = getAll();
		List<Project> projectsFromCategory = new ArrayList<>();

		for (Project project : projects) {
			if (project.getCategoryID() == category.getUniqueID()) {
				projectsFromCategory.add(project);
			}
		}

		return projectsFromCategory;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}

	@Override
	public void remove(Project project) {
		// TODO Auto-generated method stub

	}

}
