package ua.dborisenko.kickstarter;

import java.io.IOException;

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

    private static final String INVESTMENT_JSP_PATH = "/WEB-INF/jsp/investment.jsp";

    private static final String PROJECT_JSP_PATH = "/WEB-INF/jsp/project.jsp";
    private static final String PROJECT_OUT_URL = "?page=project&id=";
    private static final String CATEGORY_JSP_PATH = "/WEB-INF/jsp/category.jsp";
    private static final String CATEGORIES_JSP_PATH = "/WEB-INF/jsp/categories.jsp";
    private static final String ERROR_404_JSP_PATH = "/WEB-INF/jsp/error404.jsp";
    private static final String ERROR_400_JSP_PATH = "/WEB-INF/jsp/error400.jsp";
    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        quoteDao = new QuoteDao();
        categoryDao = new CategoryDao();
        context = config.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
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
                int projectId = Integer.valueOf(request.getParameter("project_id"));
                showInvestment(request, response, projectId);
            } else {
                showError404(request, response);
            }
        } catch (NumberFormatException e) {
            showError400(request, response);
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
            showError404(request, response);
        }
    }

    private void showError404(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = context.getRequestDispatcher(ERROR_404_JSP_PATH);
        dispatcher.forward(request, response);
    }

    private void showError400(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = context.getRequestDispatcher(ERROR_400_JSP_PATH);
        dispatcher.forward(request, response);
    }

    private void addInvestment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            showError400(request, response);
        }
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter("project_id"));
            Question question = new Question();
            question.setRequest(request.getParameter("question_request"));
            categoryDao.addQuestion(projectId, question);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            showError400(request, response);
        }
    }

    void showCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("quote", quoteDao.getRandomQuote());
        request.setAttribute("categories", categoryDao.getCategories());
        RequestDispatcher dispatcher = context.getRequestDispatcher(CATEGORIES_JSP_PATH);
        dispatcher.forward(request, response);

    }

    void showCategory(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        Category category = categoryDao.getCategoryById(id);
        if (category == null) {
            showError404(request, response);
        }
        request.setAttribute("category", category);
        request.setAttribute("projects", category.getProjects());
        RequestDispatcher dispatcher = context.getRequestDispatcher(CATEGORY_JSP_PATH);
        dispatcher.forward(request, response);
    }

    void showProject(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
        Project project = categoryDao.getProjectById(id);
        if (project == null) {
            showError404(request, response);
        }
        request.setAttribute("project", project);
        request.setAttribute("questions", project.getQuestions());
        Category category = categoryDao.getCategoryByProjectId(id);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = context.getRequestDispatcher(PROJECT_JSP_PATH);
        dispatcher.forward(request, response);
    }

    void showInvestment(HttpServletRequest request, HttpServletResponse response, int projectId)
            throws ServletException, IOException {
        Project project = categoryDao.getProjectById(projectId);
        categoryDao.getRewards(project);
        request.setAttribute("project", project);
        request.setAttribute("rewards", project.getRewards());
        RequestDispatcher dispatcher = context.getRequestDispatcher(INVESTMENT_JSP_PATH);
        dispatcher.forward(request, response);
    }
}
