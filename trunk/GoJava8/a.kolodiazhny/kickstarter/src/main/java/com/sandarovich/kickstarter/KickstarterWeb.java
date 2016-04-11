package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.*;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class KickstarterWeb extends HttpServlet {

    public static final String VIEW_PAGE_PARAMETER = "view";
    public static final String CATEGORIES_VIEW = "categories";
    public static final String CATEGORY_VIEW = "category";
    public static final String PROJECT_VIEW = "project";
    public static final String ACTION_ADD_QUESTION = "addQuestion";
    private static final String QUESTION_VIEW = "question";
    private static final String ACTION_ADD_INVEST = "addInvestment";
    private static final String INVEST_VIEW = "invest";

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AwardDao awardDao;

    private ServletContext context;

    public void init(ServletConfig config) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        context = config.getServletContext();
    }

    public void destroy() {
        quoteDao = null;
        categoryDao = null;
        questionDao = null;
        projectDao = null;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String requestedAction = req.getParameter("action");
        if (ACTION_ADD_QUESTION.equals(requestedAction)) {
            addQuestion(req, res);
        } else if (ACTION_ADD_INVEST.equals(requestedAction)) {
            addInvestment(req, res);
        }
    }

    private void addInvestment(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int projectId = 0;
        Payment payment = new Payment();
        if (req.getParameter("award") == null || req.getParameter("award").isEmpty()) {
            payment.setAmount(Double.valueOf(req.getParameter("amount")));
        } else {
            payment.setAmount(Double.valueOf(req.getParameter("award")));
        }
        payment.setCardHolder(req.getParameter("cardHolder"));
        payment.setCardNumber(req.getParameter("cardNumber"));
        try {
            projectId = Integer.valueOf(req.getParameter("projectId"));
            projectDao.findProjectById(projectId);
        } catch (NumberFormatException | NoResultException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        projectDao.invest(payment, projectId);
        res.sendRedirect("/kickstarter/kickstarter?view=project&id=" + projectId);
    }

    private void addQuestion(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(req.getParameter("projectId"));
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Question question = new Question();
        question.setText(req.getParameter("question"));
        questionDao.addQuestion(question, projectId);
        res.sendRedirect("/kickstarter/kickstarter?view=project&id=" + projectId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
        String requestView = req.getParameter(VIEW_PAGE_PARAMETER);
        if (requestView == null || req.getQueryString() == null) {
            showMainPage(req, res);
        } else if (CATEGORIES_VIEW.equals(requestView)) {
            showCategoriesPage(req, res);
        } else if (CATEGORY_VIEW.equals(requestView)) {
            showCategoryPage(req, res);
        } else if (PROJECT_VIEW.equals(requestView)) {
            showProjectPage(req, res);
        } else if (QUESTION_VIEW.equals(requestView)) {
            showQuestionPage(req, res);
        } else if (INVEST_VIEW.equals(requestView)) {
            showInvestPage(req, res);
        }
    }

    private void showInvestPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);
        } catch (NoResultException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        List<Award> awards = awardDao.getAwardsByProject(project);
        req.setAttribute("project", project);
        req.setAttribute("title", "Invest");
        req.setAttribute("awards", awards);
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/invest.jsp");
        rd.forward(req, res);
    }

    private void showQuestionPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);
        } catch (NoResultException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute("title", "Question");
        req.setAttribute("project", project);
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/question.jsp");
        rd.forward(req, res);
    }

    private void showProjectPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int projectId = 0;
        try {
            projectId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Project project = null;
        try {
            project = projectDao.findProjectById(projectId);

        } catch (NoResultException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        List<Question> questions;
        questions = questionDao.getQuestions(project);
        Category category = categoryDao.findCategoryByProject(project);
        req.setAttribute("title", project.getName());
        req.setAttribute("project", project);
        req.setAttribute("questions", questions);
        req.setAttribute("category", category);
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/project.jsp");
        rd.forward(req, res);
    }

    private void showCategoryPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int categoryId = 0;
        try {
            categoryId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Category category = null;
        try {
            category = categoryDao.findCategoryById(categoryId);
        } catch (NoResultException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute("title", category.getName());
        req.setAttribute("category", category);
        req.setAttribute("projects", projectDao.getProjects(category));
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/category.jsp");
        rd.forward(req, res);
    }

    private void showCategoriesPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("title", "Categories");
        List<Category> categories = categoryDao.getCategories();
        req.setAttribute("categories", categories);
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/layouts/categories.jsp");
        rd.forward(req, res);
    }

    private void showMainPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Quote quote = quoteDao.getRandomQuota();
        req.setAttribute("quote", "\"" + quote.getQuote() + "\" - " + quote.getAuthor());
        req.setAttribute("title", "Kickstarter");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/layouts/index.jsp");
        rd.forward(req, res);
    }


}
