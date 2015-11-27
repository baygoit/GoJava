package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

import java.io.*;
import java.util.*;

public class FileCategoryStorage implements CategoryStorage {
    private final String categoryPath;

    private final String projectPath;

    public FileCategoryStorage(String categoryPath, String projectPath) {
        this.categoryPath = categoryPath;
        this.projectPath = projectPath;

        File categoryFile = new File(categoryPath);
        File projectFile = new File(projectPath);
        try {
            if (!categoryFile.exists()) {
                categoryFile.createNewFile();
            }
            if (!projectFile.exists()) {
                projectFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        try (BufferedReader categoryReader = new BufferedReader(new FileReader(categoryPath));
             BufferedReader projectReader = new BufferedReader(new FileReader(projectPath)))
        {
            String categoryName;
            while ((categoryName = categoryReader.readLine()) != null) {
                Category category = new Category(categoryName);
                categories.add(category);
            }

            String line;
            final int numberOfProjectParameters = 8;
            int lineNumber = 0;
            String projectName = "";
            String projectCategoryName = "";
            String shortDescription = "";
            String description = "";
            String history = "";
            String videoUrl = "";
            int moneyNeeded = 0;
            int daysLeft = 0;
            while ((line = projectReader.readLine()) != null) {
                if (lineNumber % (numberOfProjectParameters + 1) == 0) {
                    projectName = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 1) {
                    projectCategoryName = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 2) {
                    shortDescription = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 3) {
                    description = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 4) {
                    history = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 5) {
                    videoUrl = line;
                } else if (lineNumber % (numberOfProjectParameters + 1) == 6) {
                    moneyNeeded = Integer.parseInt(line);
                } else if (lineNumber % (numberOfProjectParameters + 1) == 7) {
                    daysLeft = Integer.parseInt(line);

                    Category category = null;
                    for (Category currentCategory : categories) {
                        if (currentCategory.getName().equals(projectCategoryName)) {
                            category = currentCategory;
                            break;
                        }
                    }

                    if (category == null) {
                        category = new Category(projectCategoryName);
                        categories.add(category);
                    }

                    new Project(projectName, category, shortDescription, description,
                            history, videoUrl, moneyNeeded, daysLeft);
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public void add(Category category) {
        try (BufferedWriter categoryWriter = new BufferedWriter(new FileWriter(categoryPath, true));
             BufferedWriter projectWriter = new BufferedWriter(new FileWriter(projectPath, true)))
        {
            String categoryName = category.getName();
            categoryWriter.write(categoryName);
            categoryWriter.newLine();

            List<Project> projects = category.getProjects();
            for (Project project : projects) {
                projectWriter.write(project.getName());
                projectWriter.newLine();
                projectWriter.write(project.getCategory().getName());
                projectWriter.newLine();
                projectWriter.write(project.getShortDescription());
                projectWriter.newLine();
                projectWriter.write(project.getDescription());
                projectWriter.newLine();
                projectWriter.write(project.getHistory());
                projectWriter.newLine();
                projectWriter.write(project.getVideoUrl());
                projectWriter.newLine();
                projectWriter.write(project.getMoneyNeeded());
                projectWriter.newLine();
                projectWriter.write(project.getDaysLeft());
                projectWriter.newLine();
                projectWriter.newLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
