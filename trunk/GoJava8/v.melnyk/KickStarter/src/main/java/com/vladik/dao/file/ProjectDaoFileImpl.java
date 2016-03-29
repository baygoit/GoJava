package com.vladik.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vladik.model.Category;
import com.vladik.dao.AbstractProjectDao;
import com.vladik.model.Project;

public class ProjectDaoFileImpl extends AbstractProjectDao {
    private static final File STORAGE_FILE = new File("./src/main/resources/projects.csv");
    private static final int PROJECT_ID = 0;
    private static final int CATEGORY_ID = 1;
    private static final int TITLE = 2;
    private static final int BRIEF_DESCRIPTION = 3;
    private static final int FULL_DESCRIPTION = 4;
    private static final int VIDEO_LINK = 5;
    private static final int REQUIREMENT_SUM = 6;
    private static final int COLLECTED_SUM = 7;
    private static final int DAYS_LEFT = 8;

    @Override
    public void add(Project project) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(STORAGE_FILE, true);

            fileWriter.append(String.valueOf(project.getUniqueID()));
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(String.valueOf(project.getCategoryID()));
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(project.getTitle());
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(project.getBriefDescription());
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(project.getFullDescription());
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(project.getVideoLink());
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(String.valueOf(project.getRequiredSum()));
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(String.valueOf(project.getCollectedSum()));
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(String.valueOf(project.getDaysLeft()));
            fileWriter.append(NEW_LINE_SEPARATOR);

            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Error in CSVFileReader...");
        } finally {
            try {
                if (fileWriter != null) {
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

        try (BufferedReader fileReader = new BufferedReader(new FileReader(STORAGE_FILE))) {

            // read header
            fileReader.readLine();

            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(SEMICOLON_DELIMITER);
                if (tokens.length > 0) {
                    Project project = new Project();

                    project.setTitle(tokens[TITLE]);
                    project.setBriefDescription(tokens[BRIEF_DESCRIPTION]);
                    project.setRequiredSum(Integer.parseInt(tokens[REQUIREMENT_SUM]));
                    project.setUniqueID(Integer.parseInt(tokens[PROJECT_ID]));
                    project.setCategoryID(Integer.parseInt(tokens[CATEGORY_ID]));
                    project.setFullDescription(tokens[FULL_DESCRIPTION]);
                    project.setVideoLink(tokens[VIDEO_LINK]);
                    project.setCollectedSum(Integer.parseInt(tokens[COLLECTED_SUM]));
                    project.setDaysLeft(Integer.parseInt(tokens[DAYS_LEFT]));

                    projects.add(project);
                }
            }
        } catch (IOException e) {
            System.err.println("Error in CSVFileReader...");
        }
        return projects;
    }

    @Override
    public int getSize() {
        return getAll().size();
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
    public void remove(Project project) {

    }
}
