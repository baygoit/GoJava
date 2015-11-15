package ua.com.goit.gojava7.kickstarter.controller;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public class MainPageController {

    private static final int OPTION_EXIT = 0;
    private final Random rnd = new Random();
    private MainPage page;
    private DataStorage<Quote> quoteDAO;
    private DataStorage<Category> categoryDAO;
    private ProjectStorage projectDAO;
    private PledgeStorage pledgeDAO;
    private DataStorage<Payment> paymentDAO;
    private Scanner sc;

    public MainPageController(MainPage page, DataType dataType, InputStream stream) {
        this.page = page;
        page.showMessage("Kickstarter runs in " + dataType + " mode");
        StorageFactory factory = new StorageFactory(dataType);
        
        quoteDAO = factory.getQuoteDAO();
        categoryDAO = factory.getCategoryDAO();
        projectDAO = factory.getProjectDAO();
        paymentDAO = factory.getPaymentDAO();
        pledgeDAO = factory.getPledgeDAO();
        sc = new Scanner(stream);
    }

    public void showMainPage() {
        
        showCategoryMenu();
    }

    private void showCategoryMenu() {
        List<Category> categories = categoryDAO.getAll();
        printCategories(categories);

        int option = getMenuOptionFromUser(categories.size());

        if (option != OPTION_EXIT) {
            showProjectsInCategoryMenu(categories.get(option - 1));
            showCategoryMenu();
        }
    }

    private void showProjectsInCategoryMenu(Category category) {
        List<Project> foundProjects = projectDAO.getByCategory(category);
        printProjects(foundProjects);

        int option = getMenuOptionFromUser(foundProjects.size());

        if (option != OPTION_EXIT) {
            showProjectDetailsMenu(foundProjects.get(option - 1));
            showProjectsInCategoryMenu(category);
        }
    }

    private void showProjectDetailsMenu(Project project) {
        printProjectDetails(project);

        int option = getMenuOptionFromUser(1);

        if (option != OPTION_EXIT) {
            showPaymentMenu(project);
            showProjectDetailsMenu(project);
        }
    }

    private void showPaymentMenu(Project project) {
        printPaymentRequest(project);

        if (!processPayment(project, sc.nextLine())) {
            showPaymentMenu(project);
        }
    }

    public boolean processPayment(Project project, String paymentRequest) {
        String[] paymentParameters = paymentRequest.split(" ");

        if (paymentParameters.length != 3) {
            return false;
        } else {
            try {
                long sum = Long.parseLong(paymentParameters[2]);
                long cardID = Long.parseLong(paymentParameters[1]);
                String username = paymentParameters[0];

                Payment payment = new Payment(new User(username), cardID, sum, new Date());
                paymentDAO.add(payment);
                Pledge pledge = new Pledge(project, payment);
                pledgeDAO.add(pledge);

                project.setBalanceSum(pledgeDAO.getSum(project));

            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public void printCategories(List<Category> categories) {
        showTopPage();
        page.showCategories(categories);
    }

    public void printProjects(List<Project> projects) {
        showTopPage();
        projects.forEach(project -> project.setBalanceSum(pledgeDAO.getSum(project)));
        page.showProjects(projects);
    }

    public void printProjectDetails(Project project) {
        showTopPage();
        project.setBalanceSum(pledgeDAO.getSum(project));
        page.showProjectDetails(project);
    }

    public void printPaymentRequest(Project project) {
        showTopPage();
        page.showPaymentRequest(project);
    }

    private int getMenuOptionFromUser(int limit) {
        int option = -1;
        do {
            if (sc.hasNextInt()) {
                option = sc.nextInt();
            } else {
                sc.next();
            }

            if (option > limit || option < 0) {
                page.showMessage("Use positive numeric index not higher than " + limit);
            }
        } while (option > limit || option < 0);
        sc.nextLine();
        return option;
    }

    public void showTopPage() {

        page.showDivider();

        showRandomQuote(rnd);

    }

    public void showRandomQuote(Random rnd) {

        List<Quote> quotes = quoteDAO.getAll();

        if (!quotes.isEmpty()) {
            page.showQuote(quotes.get(rnd.nextInt(quotes.size())));
        }

    }

}
