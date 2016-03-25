package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoFactory;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDaoFactory;
import com.sandarovich.kickstarter.domain.Award;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;
import com.sandarovich.kickstarter.domain.payment.Payment;
import com.sandarovich.kickstarter.domain.payment.PaymentSystem;
import com.sandarovich.kickstarter.domain.payment.PaymentVisa;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarter {

    public static final String EXIT_INPUT = "0";
    public static final String CATEGORY_INPUT = "1";
    public static final String INVEST_INPUT = "2";
    public static final String ASK_QUESTION_INPUT = "3";
    public static final String OPTION_NOT_FOUND = ">> Option not found";
    public static final String SHORT_DIVIDER = "---";
    public static final String MANUALLY_AWARD_INPUT = "0";
    public static final String BYE = ">> Bye!";
    public static final String SUCCESSFULLY_INVESTED = "Successfully invested.";
    public static final String AMOUNT_IS_INCORRECT = "Amount is incorrect. Operation aborted. Let's try again..";

    private IO io;
    private DaoMode daoMode;
    private QuoteDao quoteDao;
    private CategoryDao categoryDao;
    private Category category;
    private Project project;

    public KickStarter(IO io, DaoMode daoMode) {
        this.io = io;
        this.daoMode = daoMode;
        this.quoteDao = new QuoteDaoFactory().getQuotaDao(daoMode);
        this.categoryDao = new CategoryDaoFactory().getCategoryDao(daoMode);
    }

    public void run() {
        io.writeDaoMode(daoMode);
        io.writeApplicationTitle();
        io.writeQuote(quoteDao);
        showAllCategoriesView();
    }

    private void readProjectViewOptions() {
        String inputValue = io.read();
        if (EXIT_INPUT.equals(inputValue)) {
            showAllCategoriesView();
        }
        project = readProject(inputValue);
        if (project == null) {
            io.write(OPTION_NOT_FOUND);
            readProjectViewOptions();
        }
        showProjectsDetailsView();
    }

    private void showProjectsDetailsView() {
        io.writeViewTitle("Project Details");
        io.writeProjectDetails(project);
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " - Projects");
        io.write(CATEGORY_INPUT + " - Category");
        io.write(INVEST_INPUT + " - Invest");
        io.write(ASK_QUESTION_INPUT + " - Ask a question");
        readProjectsDetailsViewOptions();
    }

    private void readProjectsDetailsViewOptions() {
        String inputValue = io.read();
        if (EXIT_INPUT.equals(inputValue)) {
            showProjectsView();
        } else if (CATEGORY_INPUT.equals(inputValue)) {
            showAllCategoriesView();
        } else if (INVEST_INPUT.equals(inputValue)) {
            showInvestView();
        } else if (ASK_QUESTION_INPUT.equals(inputValue)) {
            showAskQuestionView();
        } else {
            io.write(OPTION_NOT_FOUND);
            readProjectsDetailsViewOptions();
        }
    }

    private void showAskQuestionView() {
        io.writeViewTitle("Ask a question:");
        io.write("Please, enter you question: ");
        String question = io.read();
        categoryDao.addQuestion(project, question);
        showProjectsDetailsView();
    }

    private void showInvestView() {
        io.writeViewTitle("Invest:");
        investIntoProject();
        showProjectsDetailsView();
    }

    private void investIntoProject() {
        Payment payment = readPaymentDetails();
        PaymentSystem paymentSystem = new PaymentVisa();
        if (paymentSystem.isPossible(payment.getAmount())
                && paymentSystem.isProcess(payment.getAmount())) {
            categoryDao.investIntoProject(project, payment.getAmount());
            io.write(SHORT_DIVIDER);
            io.write(payment.getAmount() + " $ " + SUCCESSFULLY_INVESTED);
            io.write(SHORT_DIVIDER);
        }

    }

    private Payment readPaymentDetails() {
        Payment result = new Payment();
        io.write("Please enter your name:");
        result.setCardHolder(io.read());
        io.write("Please enter your Card number:");
        result.setCardNumber(io.read());
        showAwardView();
        double amount = readPaymentAmount();
        result.setAmount(amount);
        return result;
    }

    private double readPaymentAmount() {
        String inputValue = io.read();
        if (MANUALLY_AWARD_INPUT.equals(inputValue)) {
            io.write("Please enter amount:");
            Double amount = readAmount();
            if (amount == null) {
                io.write(AMOUNT_IS_INCORRECT);
                showAwardView();
                return readPaymentAmount();
            }
            return amount;
        }

        // TODO Strange-look. To refactor lines bellow
        int counter = 1;
        int currentOption = 0;
        try {
            currentOption = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            io.write(OPTION_NOT_FOUND);
            showAwardView();
            return readPaymentAmount();
        }
        for (Award award : categoryDao.getProjectAwards(project)) {
            if (counter++ == currentOption) {
                return award.getAmount();
            }
        }
        io.write(OPTION_NOT_FOUND);
        return readPaymentAmount();
    }

    private void showAwardView() {
        io.writeViewTitle("Award options:");
        io.writeProjectAwards(categoryDao, project);
        io.write(SHORT_DIVIDER);
        io.write(MANUALLY_AWARD_INPUT + " - Manually amount mode:");
    }

    private void exitAppication() {
        io.write(BYE);
        System.exit(0);
    }

    private void showProjectsView() {
        io.writeViewTitle("<<Projects>> ");
        io.writeAllProjectsAsTable(categoryDao.getProjects(category));
        io.write(SHORT_DIVIDER);
        io.writeAllProjectsAsList(categoryDao, category);
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " -> Exit");
        readProjectViewOptions();
    }

    private void showCategory() {
        io.writeCategory(category);
        showProjectsView();
    }

    private void showAllCategoriesView() {
        io.writeViewTitle("<<Categories:>> ");
        io.writeAllCategoriesAsList(categoryDao);
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " -> Exit");
        readAllCategoriesOptions();
        showCategory();
    }

    private void readAllCategoriesOptions() {
        String inputValue = io.read();
        if (EXIT_INPUT.equals(inputValue)) {
            exitAppication();
        }
        category = readCategory(inputValue);
        if (category == null) {
            io.write(OPTION_NOT_FOUND);
            readAllCategoriesOptions();
        }

    }

    public Category readCategory(String value) {
        if (!categoryDao.isValidCategory(value)) {
            return null;
        }
        return categoryDao.findCategoryById(Integer.parseInt(value));
    }

    public Project readProject(String inputValue) {
        Project result = categoryDao.findProject(category, inputValue);
        return result;
    }

    public Double readAmount() {
        try {
            return Double.valueOf(io.read());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}