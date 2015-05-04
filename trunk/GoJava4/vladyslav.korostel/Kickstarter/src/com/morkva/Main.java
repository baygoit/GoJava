package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.model.*;
import com.morkva.model.impl.CategoryRepositoryImpl;
import com.morkva.model.impl.QuotesRepositoryImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Category[] defaultCategories = new Category[]{
            new Category("Програмное обеспечение"),
            new Category("Видео"),
            new Category("Игры")
    };

    static String[] questionsAndAnswers = new String[] {
            "Question 1: Answer",
            "Question 2: Answer",
            "Question 3: Answer"
    };

    static Project[] softwareCategoryProjects = new Project[] {
            new Project("Instant Messenger Qip", "A very tiny instant messenger for all Platforms and IE6", 50000, 37000, 5, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Kickstarter", "One more kickstarter", 100, 5, 31, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Global IT forum", "IT forum for all planet and our solar system", 5, 2, 100, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Project[] videoCategoryProjects = new Project[] {
            new Project("Avengers 16", "New avengers from IT developers", 500, 0, 128, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Avatar 32", "New blue people from blue planet with blue scenario, not gay", 59999000, 49999000, 256, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Batmen 64", "Need anoter one actor for batman, not gay", 699, 3, 512, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Superman 1024", "History of a developer from Crypton", 600000, 4500, 1024, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Project[] gamesCategoryProjects = new Project[] {
            new Project("256-bit mario", "New mario for Oculus Rift", 3000, 0, 60, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("Quake 2.5", "Doom is too boring", 10000, 500, 31, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers),
            new Project("CS 3.14", "New counter strike from ukrainian developers (need money for beer)", 100, 0, 3, "History of the project", "http://youtube.com/kdjh1231", questionsAndAnswers)
    };

    static Quote[] defaultQuotes = new Quote[] {
            new Quote("«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
            new Quote(" Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
            new Quote("Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
            new Quote(" Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")
    };

    static Quoter quoter;
    static CategoryRepository categoryRepository;

    public static void main(String[] args) throws IOException {

        defaultCategories[0].setProjects(softwareCategoryProjects);
        defaultCategories[1].setProjects(videoCategoryProjects);
        defaultCategories[2].setProjects(gamesCategoryProjects);

        quoter = new ConsoleQuoter(new QuotesRepositoryImpl(defaultQuotes));
        categoryRepository = new CategoryRepositoryImpl(defaultCategories);

        while (true) {
            System.out.println("Your quote: " + quoter.quote());
            Category[] categories = categoryRepository.getAllCategories();
            System.out.println("Select category: ");
            for (int i = 0; i < categories.length; i++) {
                System.out.println(i + 1 + ": " + categories[i].getName());
            }
            System.out.println();
            System.out.println("Press 0 for exit");

            Scanner scanner = new Scanner(System.in);
            int code = scanner.nextInt();

            if (code == 0) {
                break;
            } else {
                if (code <= categories.length) {
                    Category currentCategory = categories[code-1];
                    loop: while (true) {
                        System.out.println("You select category: " + currentCategory.getName());
                        System.out.println("Category projects: ");
                        Project[] currentCategoryProjects = currentCategory.getProjects();
                        for (int i = 0; i < currentCategoryProjects.length; i++) {
                            System.out.print("    " + (i + 1) + ": ");
                            System.out.println(currentCategoryProjects[i].getName());
                            System.out.println("        Short Description: " + currentCategoryProjects[i].getShortDescr());
                            System.out.println("        Need money: " + currentCategoryProjects[i].getNeedMoney());
                            System.out.println("        Current money: " + currentCategoryProjects[i].getCurrentMoney());
                            System.out.println("        Days left: " + currentCategoryProjects[i].getDaysLeft());
                        }
                        System.out.println();
                        System.out.println("Press 0 for exit from this category");
                        int code2 = scanner.nextInt();
                        if (code2 == 0) {
                            break;
                        } else {
                            if (code2 <= currentCategoryProjects.length) {
                                Project currentProject = currentCategoryProjects[code2-1];
                                while (true) {
                                    System.out.println(currentProject.getName());
                                    System.out.println("        Short Description: " + currentProject.getShortDescr());
                                    System.out.println("        Need money: " + currentProject.getNeedMoney());
                                    System.out.println("        Current money: " + currentProject.getCurrentMoney());
                                    System.out.println("        Days left: " + currentProject.getDaysLeft());
                                    System.out.println("        History: " + currentProject.getHistory());
                                    System.out.println("        Video URL: " + currentProject.getUrlVideo());
                                    System.out.println("        Questions And Answers: ");
                                    for (String s : currentProject.getQuestionsAndAnswers()) {
                                        System.out.println("            " + s);
                                    }
                                    System.out.println();
                                    System.out.println("Press 0 to return back");
                                    System.out.println("Press -1 to return to the menu");
                                    int code3 = scanner.nextInt();
                                    if (code3 == 0) break;
                                    else if (code3 == -1) break loop;
                                    else System.out.println("Wrong code!");
                                }
                            } else {
                                System.out.println("Wrong project!");
                            }
                        }
                    }
                } else {
                    System.out.println("Wrong number!");
                }
            }
        }

    }
}
