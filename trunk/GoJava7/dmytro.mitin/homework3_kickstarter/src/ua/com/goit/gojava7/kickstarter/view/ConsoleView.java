package ua.com.goit.gojava7.kickstarter.view;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;
import ua.com.goit.gojava7.kickstarter.view.page.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleView implements View {
    private Page currentPage;

    private Page previousPage;

    private Controller controller;

    private BufferedReader reader;

    public ConsoleView(Controller controller) {
        this.currentPage = new GreetingPage(this);
        this.previousPage = new GreetingPage(this);
        this.controller = controller;
        // implementing Observer pattern
        controller.getKickstarter().addObserver(this);
    }

    public BufferedReader getReader() {
        return reader;
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.reader = reader;
            while (true) {
                try {
                    currentPage.show();
                    String command = reader.readLine();
                    if (command == null) {
                        break;
                    }
                    Page nextPage = currentPage.getUpdated(command);
                    previousPage = currentPage;
                    currentPage = nextPage;
                } catch (ExitException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Page updatePageToStandard(String command) {
        if (command.equals("h") || command.equals("H")) {
            return new HelpPage(this);
        } else if (command.equals("x") || command.equals("X") || command.equals("0")) {
            return new ExitPage();
        } else if (command.equals("c") || command.equals("C")) {
            return new CategoryListPage(this);
        } else if (command.equals("u") || command.equals("U")) {
            return currentPage;
        } else if (command.equals("b") || command.equals("B")) {
            return previousPage;
        }
        return null;
    }

    public static boolean isStandard(String command) {
        if (command.equals("h") || command.equals("H")
                || command.equals("x") || command.equals("X") || command.equals("0")
                || command.equals("c") || command.equals("C")
                || command.equals("u") || command.equals("U")
                || command.equals("b") || command.equals("B")) {
            return true;
        } else {
            return false;
        }
    }

    // implementing Observer pattern
    @Override
    public void handleNotification() throws ExitException, IOException {
        currentPage.show();
    }

    @Override
    public void printRandomQuote() {
        Quote quote = controller.getRandomQuote();
        System.out.println(quote.getText() + " (" + quote.getAuthor() + ")");
    }

    @Override
    public void printCategories() {
        List<Category> categories = controller.getKickstarter().getCategoryStorage().getCategories();
        System.out.println("Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    @Override
    public void printProjects(Category category) {
        List<Project> projects = category.getProjects();
        System.out.println("Category: " + category.getName() + ".");
        System.out.println();
        System.out.println("Projects:");
        System.out.println();
        for (int i = 0; i < projects.size(); i++) {
            System.out.println("Number: " + (i + 1));
            printProjectInfo(projects.get(i));
            System.out.println();
        }
    }

    @Override
    public void printProjectInfo(Project project) {
        System.out.println("Project: " + project.getName());
        System.out.println("Description: " + project.getShortDescription());
        System.out.println("Money needed: $" + project.getMoneyNeeded());
        System.out.println("Money donated: $" + project.getMoneyDonated());
        System.out.println("Days left: " + project.getDaysLeft());
    }

    @Override
    public void printProjectDetailedInfo(Project project) {
        System.out.println("Category: " + project.getCategory().getName());
        System.out.println("Project: " + project.getName());
        System.out.println("Description: " + project.getDescription());
        System.out.println("History: " + project.getHistory());
        System.out.println("Video: " + project.getVideoUrl());
        System.out.println("Money needed: $" + project.getMoneyNeeded());
        System.out.println("Money donated: $" + project.getMoneyDonated());
        System.out.println("Days left: " + project.getDaysLeft());
        System.out.println("Questions:");
        for (String question : project.getQuestions()) {
            System.out.println(question);
        }
    }
}
