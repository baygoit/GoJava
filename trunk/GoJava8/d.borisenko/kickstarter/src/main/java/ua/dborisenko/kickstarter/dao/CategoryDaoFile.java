package ua.dborisenko.kickstarter.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

public class CategoryDaoFile extends CategoryDao {

    private String categoriesFileName = "./src/main/resources/categories.txt";
    private String projectsFileName = "./src/main/resources/projects.txt";

    public void setCategoriesFileName(String categoriesFileName) {
        this.categoriesFileName = categoriesFileName;
    }

    public void setProjectsFileName(String projectsFileName) {
        this.projectsFileName = projectsFileName;
    }

    void addProjects() {
        try (BufferedReader is = new BufferedReader(new FileReader(projectsFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] projectParts = line.split("#");
                Project project = new Project();
                project.setId(Integer.valueOf(projectParts[1]));
                project.setName(projectParts[2]);
                project.setDescription(projectParts[3]);
                project.setRequiredSum(Integer.valueOf(projectParts[4]));
                project.setCollectedSum(Integer.valueOf(projectParts[5]));
                project.setDaysLeft(Integer.valueOf(projectParts[6]));
                project.setHistory(projectParts[7]);
                project.setVideoUrl(projectParts[8]);
                project.setDiscussionUrl(projectParts[9]);
                for (Category category : categories) {
                    if (Integer.valueOf(projectParts[0]).equals(category.getId())) {
                        category.addProject(project);
                    }
                }
            }
        } catch (IOException e) {
            categories.clear();
            throw new IllegalStateException("Cannot read projects from file");
        }
    }

    public void fillCategories() {
        try (BufferedReader is = new BufferedReader(new FileReader(categoriesFileName))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] categoryParts = line.split("#");
                Category category = new Category(Integer.valueOf(categoryParts[0]), categoryParts[1]);
                categories.add(category);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read categories from file");
        }
        addProjects();
    }
}
