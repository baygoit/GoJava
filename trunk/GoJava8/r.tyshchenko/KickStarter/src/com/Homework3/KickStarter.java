package com.Homework3;

import java.util.*;

public class KickStarter {

    private Categories categories;
    private Progects progects;


    public KickStarter(Categories categories, Progects progects) {
        this.categories = categories;
        this.progects = progects;
    }
    public void run() {
        GetQuotes generator = new GetQuotes();
        generator.getRandomQuotes();
        System.out.println();
        askKategory();
        int menuIndex = selectMenu();
        Category category = chooseCategory(menuIndex);

        Progect[] foundProjects = progects.getProgect(category);
        printProgects(foundProjects);
        projectMenu(foundProjects);
    }

    private void projectMenu(Progect[] foundProjects) {
        while (true) {
            askProject(foundProjects);
            int projectMenuIndex = selectMenu();
            if (projectMenuIndex == 0) {
                break;
            }
            Progect progect = chooseProhect(projectMenuIndex, foundProjects);
            if (progect == null) {
                continue;
            }
            chooseProhect(progect);
            printProjectDetails(progect);
        }
    }

    private Progect chooseProhect (int projectMenuIndex, Progect[] foundProjects ) {
        if (projectMenuIndex <= 0 || foundProjects.length <= projectMenuIndex) {
            System.out.println("неверный индекс " + projectMenuIndex);
            return  null;
        }
        Progect progect = foundProjects[projectMenuIndex - 1];
        return  progect;
    }

    public void printProgects(Progect[] foundProjects) {
        for (int index =0; index < foundProjects.length; index++) {
            Progect progect = foundProjects[index];
            System.out.print((index+1) + "- ");
            printProject(progect);
        }
    }

    private  void askProject(Progect[] foundProjects ) {
        if (foundProjects.length == 0) {
            System.out.println("В этой категории нет проектов, нажмите 0 для выхода!");
        } else {
            int from = 1;
            int to = foundProjects.length;
            System.out.println("Выберите проект : [" + from + " - " + to + "] или 0 для выхода");
            System.out.println();
        }
    }
    private void printProjectDetails(Progect progect){
        printProject(progect);
        System.out.println(progect.getHistory());
        System.out.println(progect.getDemoVideo());
        String questionAnswers = progect.getQuestionAnswers();
        if (questionAnswers != null) {
            System.out.println(progect.getQuestionAnswers());
        }
        System.out.println("----------------------------------");
    }

    public Category chooseCategory(int menuIndex) {
        if (menuIndex <= 0 || categories.size() < menuIndex) {
            System.out.println("неверный индекс " + menuIndex);
            return null;
        }
        Category category = categories.get(menuIndex-1);

        System.out.println("Ви вибрали категорию - " + category.getName());
        System.out.println();
        return category;
    }

    public void printProject(Progect progect) {
        System.out.println(progect.getName());
        System.out.println(progect.getDescription());
        System.out.println("необходимая сума " + progect.getAmount() + " грн");
        System.out.println("собрано " + progect.getExist() + " грн");
        System.out.println("осталось дней " + progect.getDays());
        System.out.println("------------------------------");
        System.out.println();
    }

    public void askKategory() {
        System.out.println("Выберите категорию");
        System.out.println(Arrays.toString(categories.getCategories()));
        System.out.println();
    }

    public int selectMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private void chooseProhect (Progect progect) {
        System.out.println("Ви вибрали проект - " + progect.getName());
        System.out.println();

    }
}
