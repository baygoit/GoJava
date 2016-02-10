package com.kickstarter;

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
            int categoryIndex = selectMenu();
            Category category = chooseCategory(categoryIndex);
            Project[] foundProjects = projects.getProjects(category);
            printProjects(foundProjects);
            while (true){
                askProject();
                int projectIndex = selectMenu();
                Project project = foundProjects[projectIndex];
                chooseProject(project);
                printProjectDetails(project);
            }
        }
    }

    private void askProject() {
        System.out.println("Выберите проект:");
    }

    private void printProjectDetails(Project project) {
        printProject(project);
        System.out.println(project.getHistory());
        System.out.println(project.getDemoVideo());
        System.out.println(project.getQuestionAnswers());
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
            System.out.print(i + " - ");
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
        System.out.println();
        System.out.println("Выберите категорию:");
        System.out.println(Arrays.toString(categories.getCategories()));
    }

    private Category chooseCategory(int categoryIndex) {
        Category category = categories.get(categoryIndex);
        System.out.println("Вы выбрали категорию: " + category.getName());
        System.out.println("------------------------------------------");
        return category;
    }

    private int selectMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
