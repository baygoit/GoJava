package ua.dborisenko.kickstarter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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

public class Kickstarter extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoInitializer daoInitializer;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.getQuoteDao();
        categoryDao = daoInitializer.getCategoryDao();
        context = config.getServletContext();
    }

    @Override
    public void destroy() {
        try {
            daoInitializer.closeSqlConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedPage = request.getParameter("page");
        if ("categories".equals(requestedPage) || request.getQueryString() == null) {
            showCategories(request, response);
        } else if ("category".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showCategory(request, response, id);
        } else if ("project".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showProject(request, response, id);
        } else if ("investment".equals(requestedPage)) {
            int id = Integer.valueOf(request.getParameter("id"));
            showInvestment(request, response, id);
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

    private void addInvestment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        showProject(request, response, projectId);
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int projectId = Integer.valueOf(request.getParameter("project_id"));
        Question question = new Question();
        question.setRequest(request.getParameter("question_request"));
        categoryDao.addQuestion(projectId, question);
        showProject(request, response, projectId);
    }

    void showCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Categories");
        request.setAttribute("quote", quoteDao.getRandomQuote());
        request.setAttribute("categories", categoryDao.getCategories());
        RequestDispatcher dispatcher = context.getRequestDispatcher("/categories.jsp");
        dispatcher.forward(request, response);

    }

    void showCategory(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        request.setAttribute("title", "Projects");
        Category category = categoryDao.getCategoryById(id);
        request.setAttribute("category", category);
        request.setAttribute("projects", category.getProjects());
        RequestDispatcher dispatcher = context.getRequestDispatcher("/category.jsp");
        dispatcher.forward(request, response);
    }

    void showProject(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        Project project = categoryDao.getProjectById(id);
        request.setAttribute("title", project.getName());
        request.setAttribute("project", project);
        request.setAttribute("questions", project.getQuestions());
        Category category = categoryDao.getCategoryByProjectId(id);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = context.getRequestDispatcher("/project.jsp");
        dispatcher.forward(request, response);
    }

    void showInvestment(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        request.setAttribute("title", "Investment");
        Project project = categoryDao.getProjectById(id);
        categoryDao.getRewards(project);
        request.setAttribute("project", project);
        request.setAttribute("rewards", project.getRewards());
        RequestDispatcher dispatcher = context.getRequestDispatcher("/investment.jsp");
        dispatcher.forward(request, response);
    }
}
