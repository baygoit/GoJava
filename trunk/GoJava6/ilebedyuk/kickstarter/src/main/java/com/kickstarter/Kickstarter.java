package com.kickstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Игорь on 05.02.2016.
 */
public class Kickstarter {
    private Categories categories;
    private Projects projects;

    public Kickstarter(Categories categories, Projects projects) {
        this.categories = categories;
        this.projects = projects;
    }

    public void run() {

        QuoteGenerator generator = new QuoteGenerator();
        System.out.println(generator.nextQuote());

        while (true) {
            askCategory();
            int menuIndex = selectMenu();
            Category category = chooseCategory(menuIndex);
            if (category == null) {
                continue;
            }
            Project[] foundProjects = projects.getProjects(category);
            printProjects(foundProjects);

            projectMenu(foundProjects);
        }
    }

    private void projectMenu(Project[] foundProjects) {
        while (true){
            askProject(foundProjects);
            int projectMenuIndex = selectMenu();
            if (projectMenuIndex == 0) {
                break;
            }
            Project project = chooseProject(projectMenuIndex, foundProjects);
            if (project == null) {
                continue;
            }
            chooseProject(project);
            printProjectDetails(project);
        }
    }

    private Project chooseProject(int projectMenuIndex, Project[] foundProjects) {
        if (projectMenuIndex <= 0 || foundProjects.length < projectMenuIndex) {
            System.out.println("Неверный индекс меню " + projectMenuIndex);
            return null;
        }
        return foundProjects[projectMenuIndex - 1];
    }


    private void askProject(Project[] foundProjects) {
        int from = 1;
        int to = foundProjects.length;
        System.out.println("Выберите проект: [" + from + ".." + to + "]");
    }

    private void printProjectDetails(Project project) {
        printProject(project);
        System.out.println(project.getHistory());
        System.out.println(project.getDemoVideo());
        String questionAnswers = project.getQuestionAnswers();
        if (questionAnswers != null) {
            System.out.println(questionAnswers);
        }
        System.out.println("------------------------------------------");
    }

    private Project chooseProject(Project project) {
        System.out.println("Вы выбрали проект: " + project.getName());
        System.out.println("------------------------------------------");
        return project;
    }

    private void printProjects(Project[] foundProjects) {

        for (int i = 0; i < foundProjects.length; i++) {
            Project project = foundProjects[i];
            System.out.print((i + 1) + " - ");
            printProject(project);
        }
    }

    private void printProject(Project project) {
        System.out.println(project.getName());
        System.out.println(project.getDescription());
        System.out.println("Нужно собрать " + project.getAmount() + " грн за " + project.getDays() + " дней");
        System.out.println("Уже собрали: " + project.getExist() + " грн");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    private void askCategory() {
        System.out.println("Выберите категорию:");
        System.out.println(Arrays.toString(categories.getCategories()));
    }

    private Category chooseCategory(int menuIndex) {
        if (menuIndex <= 0 || menuIndex > categories.size()) {
            System.out.println("Неверный индекс меню " + menuIndex);
            return null;
        }

        Category category = categories.get(menuIndex - 1);
        System.out.println("Вы выбрали категорию: " + category.getName());
        System.out.println("------------------------------------------");
        return category;
    }

    private int selectMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
