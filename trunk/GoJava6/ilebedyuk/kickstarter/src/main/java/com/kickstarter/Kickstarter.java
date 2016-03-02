package com.kickstarter;

import java.util.Arrays;

/**
 * Created by Игорь on 05.02.2016.
 */
public class Kickstarter {
    private Categories categories;
    private Projects projects;
    private IO io;
    private QuoteGenerator generator;

    public Kickstarter(Categories categories, Projects projects, IO io, QuoteGenerator quoteGenerator) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
        this.generator = quoteGenerator;
    }

    public void run() {
        println(generator.nextQuote());
        categoryMenu().run();
        println("Спасибо за использование нашей программы!");
    }

    private Menu categoryMenu() {
        return new Menu(io) {
            @Override
            Menu nextMenu(Object selected) {
                Category category = (Category) selected;
                Project[] found = projects.getProjects(category);
                printProjects(found);
                return projectsMenu(found);
            }

            @Override
            Object choose(int menu) {
                return chooseCategory(menu);
            }

            @Override
            void ask() {
                askCategory();
            }
        };
    }

    private Menu projectsMenu(final Project[] found) {
        return new Menu(io) {
            @Override
            Menu nextMenu(Object selected) {
                Project project = (Project) selected;
                chooseProject(project);
                printProjectDetails(project);
                return projectMenu(project);
            }

            @Override
            Object choose(int menu) {
                return chooseProject(menu, found);
            }

            @Override
            void ask() {
                askProjects(found);
            }
        };
    }

    private Menu projectMenu(final Project project) {
        return new Menu(io) {
            @Override
            Menu nextMenu(Object selected) {
                Integer menu = (Integer) selected;

                if (menu == 1) {
                    println("Спасибо, что хотите помочь проекту!");
                }
                return null;
            }

            @Override
            Object choose(int menu) {
                return menu;
            }

            @Override
            void ask() {
                askProject(project);
            }
        };
    }

    private void askProject(Project project) {
        println("Выберите, что хотите сделать с проектом: \n" +
                "[0 - выйти к списку проектов, 1 - инвестировать в проект]");
    }

    private Project chooseProject(int menu, Project[] found) {
        if (menu <= 0 || found.length < menu) {
            println("Неверный индекс меню " + menu);
            return null;
        }
        return found[menu - 1];
    }

    private void println(String message) {
        io.print(message + "\n");
    }

    private void askProjects(Project[] found) {
        if (found.length == 0) {
            println("Проектов в категории нет!. Нажмите 0 - для выхода");
        } else {
            int from = 1;
            int to = found.length;
            println("Выберите проект: [" + from + ".." + to + "] или 0 для выхода");
        }
    }


    private void printProjectDetails(Project project) {
        printProject(project);
        println(project.getHistory());
        println(project.getDemoVideo());
        String questionAnswers = project.getQuestionAnswers();
        if (questionAnswers != null) {
            println(questionAnswers);
        }
        println("------------------------------------------");
    }

    private Project chooseProject(Project project) {
        println("Вы выбрали проект: " + project.getName());
        println("------------------------------------------");
        return project;
    }

    private void printProjects(Project[] found) {

        for (int i = 0; i < found.length; i++) {
            Project project = found[i];
            io.print((i + 1) + " - ");
            printProject(project);
        }
    }

    private void printProject(Project project) {
        println(project.getName());
        println(project.getDescription());
        println("Нужно собрать " + project.getAmount() + " грн за " + project.getDays() + " дней");
        println("Уже собрали: " + project.getExist() + " грн");
        println("------------------------------------------");
        System.out.println();
    }

    private void askCategory() {
        println("Выберите категорию (или 0 для выхода):");
        println(Arrays.toString(categories.getCategories()));
    }

    private Category chooseCategory(int menu) {
        if (menu <= 0 || menu > categories.size()) {
            println("Неверный индекс меню " + menu);
            return null;
        }

        Category category = categories.get(menu - 1);
        println("Вы выбрали категорию: " + category.getName());
        println("------------------------------------------");
        return category;
    }
}
