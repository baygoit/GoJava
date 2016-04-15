package com.vladik.view;

import com.vladik.dao.impl.*;
import com.vladik.model.Category;
import com.vladik.model.Faq;
import com.vladik.model.Payment;
import com.vladik.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KickstarterServlet extends javax.servlet.http.HttpServlet {
    static final String INVESTMENT_JSP_PATH = "/WEB-INF/jsp/investment.jsp";
    static final String PROJECT_JSP_PATH = "/WEB-INF/jsp/project.jsp";
    static final String PROJECT_OUT_URL = "?page=project&id=";
    static final String CATEGORY_JSP_PATH = "/WEB-INF/jsp/category.jsp";
    static final String CATEGORIES_JSP_PATH = "/WEB-INF/jsp/categories.jsp";
    ServletContext context;
    @Autowired
    CategoryDaoMysqlImpl categoryDaoMysql;
    @Autowired
    ProjectDaoMysqlImpl projectDaoMysql;
    @Autowired
    PaymentDaoMysqlImpl paymentDaoMysql;
    @Autowired
    FaqDaoMysqlImpl faqDaoMysql;
    @Autowired
    QuoteDaoMysqlImpl quoteDaoMysql;
    @Autowired
    RewardsDaoMysqlImpl rewardsDaoMysql;

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
                response.sendError(404);
            }
        } catch (NumberFormatException e) {
            response.sendError(400);
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
            response.sendError(404);
        }
    }

    void showCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("quote", quoteDaoMysql.getRandomQuote());
        request.setAttribute("categories", categoryDaoMysql.getAll());
        RequestDispatcher dispatcher = context.getRequestDispatcher(CATEGORIES_JSP_PATH);
        dispatcher.forward(request, response);

    }

    void showCategory(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {

            Category category = categoryDaoMysql.getCategoryById(id);
            projectDaoMysql.getProjectsFromCategory(category);
            request.setAttribute("category", category);
            request.setAttribute("projects", category.getProjects());
            RequestDispatcher dispatcher = context.getRequestDispatcher(CATEGORY_JSP_PATH);
            dispatcher.forward(request, response);

    }

    private void addInvestment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter("project_id"));
            Payment payment = new Payment();
            payment.setCardholderName(request.getParameter("cardholder_name"));
            payment.setCardNumber(Long.parseLong(request.getParameter("card_number")));
            if (Integer.valueOf(request.getParameter("amount")) == 0) {
                payment.setDonatingSum(Integer.valueOf(request.getParameter("custom_amount")));
            } else {
                payment.setDonatingSum(Integer.valueOf(request.getParameter("amount")));
            }
            if (payment.getDonatingSum() <= 0) {
                response.sendError(400);
                return;
            }
            projectDaoMysql.invest(payment,projectId);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            response.sendError(400);
        }
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter("project_id"));
            Faq faq = new Faq();
            faq.setQuestion(request.getParameter("question_request"));
            faq.setProjectID(projectId);
            faqDaoMysql.add(faq);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            response.sendError(400);
        }
    }

    void showProject(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {

            Project project = projectDaoMysql.getProjectById(id);
            faqDaoMysql.getProjectFaqs(project);
            request.setAttribute("project", project);
            request.setAttribute("questions", project.getFaqList());
            Category category = categoryDaoMysql.getCategoryById(id);
            request.setAttribute("category", category);
            RequestDispatcher dispatcher = context.getRequestDispatcher(PROJECT_JSP_PATH);
            dispatcher.forward(request, response);

    }

    void showInvestment(HttpServletRequest request, HttpServletResponse response, int projectId)
            throws ServletException, IOException {

            Project project = projectDaoMysql.getProjectById(projectId);
            rewardsDaoMysql.getRewardsForProject(project);
            request.setAttribute("project", project);
            request.setAttribute("rewards", project.getRewardList());
            RequestDispatcher dispatcher = context.getRequestDispatcher(INVESTMENT_JSP_PATH);
            dispatcher.forward(request, response);

    }
}
