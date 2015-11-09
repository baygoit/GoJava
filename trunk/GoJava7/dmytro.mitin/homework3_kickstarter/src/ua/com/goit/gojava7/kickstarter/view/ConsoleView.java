package ua.com.goit.gojava7.kickstarter.view;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.*;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;
import ua.com.goit.gojava7.kickstarter.view.page.*;

import java.util.List;
import java.util.Scanner;


/**
 * Created by Dmytro on 06.11.2015.
 */
public class ConsoleView implements View {
    private Page currentPage;

    private Page previousPage;

    private Controller controller;

    Scanner scannerIn = new Scanner(System.in);

    public ConsoleView(Controller controller) {
        this.currentPage = new GreetingPage(this);
        this.previousPage = new GreetingPage(this);
        this.controller = controller;
        // implementing Observer pattern
        controller.getKickstarter().addObserver(this);
    }

    public Controller getController() {
        return controller;
    }

    public Scanner getScanner() {
        return scannerIn;
    }

    public void run() {
        while (true) {
            try {
                reloadPage();
                String command = scannerIn.nextLine();
                Page nextPage = currentPage.getUpdated(command);
                previousPage = currentPage;
                currentPage = nextPage;
            } catch (ExitException e) {
                break;
            }
        }
    }

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
    public void reloadPage() throws ExitException {
        currentPage.show();
    }

    public void printRandomQuote() {
        Quote quote = controller.getRandomQuote();
        System.out.println(quote.getText() + " (" + quote.getAuthor() + ")");
    }

    public void printCategories() {
        List<Category> categories = controller.getKickstarter().getCategoryStorage().getCategories();
        System.out.println("Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

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

    public void printProjectInfo(Project project) {
        System.out.println("Project: " + project.getName());
        System.out.println("Description: " + project.getShortDescription());
        System.out.println("Money needed: $" + project.getMoneyNeeded());
        System.out.println("Money donated: $" + project.getMoneyDonated());
        System.out.println("Days left: " + project.getDaysLeft());
    }

    public void printProjectDetailedInfo(Project project) {
        System.out.println("Category: " + project.getCategory().getName());
        System.out.println("Project: " + project.getName());
        System.out.println("Description: " + project.getDescription());
        System.out.println("History: " + project.getHistory());
        System.out.println("Video: " + project.getVideoUrl());
        System.out.println("Money needed: $" + project.getMoneyNeeded());
        System.out.println("Money donated: $" + project.getMoneyDonated());
        System.out.println("Days left: " + project.getDaysLeft());
    }
}
