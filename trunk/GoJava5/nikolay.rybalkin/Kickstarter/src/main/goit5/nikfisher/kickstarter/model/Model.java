package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.Projects;

public class Model {

    private Category category;
    private Categories categories;
    private Project project;
    private Projects projects;

    public Model(Category category, Categories categories, Project project, Projects projects) {
        this.category = category;
        this.categories = categories;
        this.project = project;
        this.projects = projects;

    }


    public void createNewCategory(Category category, String nameCategory) {
        category = new Category(nameCategory);
//        return category;
    }

    public static Categories creeateNewCategory(Categories categories, Category category) {
        categories.add(category);
        return categories;
    }

    public static Project creeateNewproject(Project project, String name, int amount, int exist, int days, String description) {
        project = new Project(name, amount, exist, days, "description");
        return project;
    }

    public static Project addProjectInListCategories(Project project, Category category) {
        project.setCategory(category);
        return project;
    }


    public static Projects addProjectInListProjects(Projects projects, Project project) {
        projects.add(project);
        return projects;
    }

    public static Project setHistory(Project project, String newHistory) {
        project.setQuestion(newHistory);
        return project;
    }

    public static Project setVideo(Project project, String newVideo) {
        project.setQuestion(newVideo);
        return project;
    }

    public static Project setQuestion(Project project, String newQuestion) {
        project.setQuestion(newQuestion);
        return project;
    }

    public static Project addAnsver(Project project, String newAnsver) {
        project.setAnsver(newAnsver);
        return project;
    }

    public static Category createCategory(Category category) {
        return category;
    }

}
