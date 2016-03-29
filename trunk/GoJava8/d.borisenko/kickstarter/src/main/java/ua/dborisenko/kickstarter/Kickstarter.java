package ua.dborisenko.kickstarter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.view.CategoriesView;
import ua.dborisenko.kickstarter.view.CategoryView;
import ua.dborisenko.kickstarter.view.ProjectView;
import ua.dborisenko.kickstarter.view.RewardsView;

public class Kickstarter extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DaoInitializer daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.getQuoteDao();
        categoryDao = daoInitializer.getCategoryDao();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedPage = request.getParameter("page");
        if ("categories".equals(requestedPage) || request.getQueryString() == null) {
            showCategories(response.getWriter());
        } else if ("category".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showCategory(response.getWriter(), id);
        } else if ("project".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showProject(response.getWriter(), id);
        } else if ("investment".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showRewards(response.getWriter(), id);
        } else {
            throw new IllegalArgumentException("Unknown page type!");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedAction = request.getParameter("requested_action");
        if ("ADD_QUESTION".equals(requestedAction)) {
            addQuestion(request, response);
        } else if ("ADD_INVESTMENT".equals(requestedAction)) {
            addInvestment(request, response);
        } else {
            throw new IllegalArgumentException("Unknown action type!");
        }
    }

    private void addInvestment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.valueOf(request.getParameter("project_id"));
        Investment investment = new Investment();
        investment.setCardHolderName(request.getParameter("cardholder_name"));
        investment.setCardNumber(request.getParameter("card_number"));
        if (Integer.valueOf(request.getParameter("amount")) == 0) {
            investment.setAmount(Integer.valueOf(request.getParameter("custom_amount")));
        } else {
            investment.setAmount(Integer.valueOf(request.getParameter("amount")));
        }
        categoryDao.addInvestment(projectId, investment);
        showProject(response.getWriter(), projectId);
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.valueOf(request.getParameter("project_id"));
        Question question = new Question();
        question.setRequest(request.getParameter("question_request"));
        categoryDao.addQuestion(projectId, question);
        showProject(response.getWriter(), projectId);
    }

    void showCategories(PrintWriter writer) {
        List<Category> categories = categoryDao.getCategories();
        CategoriesView view = new CategoriesView();
        view.show(writer, categories, quoteDao.getRandomQuote());
    }

    void showCategory(PrintWriter writer, int id) {
        Category category = categoryDao.getCategoryById(id);
        CategoryView view = new CategoryView();
        view.show(writer, category);
    }

    void showProject(PrintWriter writer, int id) {
        Project project = categoryDao.getProjectById(id);
        ProjectView view = new ProjectView();
        Category category = categoryDao.getCategoryByProjectId(id);
        view.show(writer, project, category);
    }

    void showRewards(PrintWriter writer, int id) {
        Project project = categoryDao.getProjectById(id);
        categoryDao.getRewards(project);
        RewardsView view = new RewardsView();
        view.show(writer, project);
    }
}
