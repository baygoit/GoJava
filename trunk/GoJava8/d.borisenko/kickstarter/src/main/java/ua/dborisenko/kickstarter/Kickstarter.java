package ua.dborisenko.kickstarter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class Kickstarter extends HttpServlet {

    private static final long serialVersionUID = 8987512933446595305L;
    static final String REQUESTED_PAGE_PARAM_NAME = "page";
    static final String REQUESTED_ACTION_PARAM_NAME = "action";

    static enum REQUESTED_ACTION {
        add_question, add_investment
    };

    static enum REQUESTED_PAGE {
        categories, category, project, investment
    }

    @Autowired
    private CategoryController categoryController;
    @Autowired
    private ProjectController projectController;
    @Autowired
    private InvestmentController investmentController;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedPage = request.getParameter(REQUESTED_PAGE_PARAM_NAME);
        if (REQUESTED_PAGE.categories.toString().equals(requestedPage) || request.getQueryString() == null) {
            categoryController.showCategories(request, response);
        } else if (REQUESTED_PAGE.category.toString().equals(requestedPage)) {
            categoryController.showCategory(request, response);
        } else if (REQUESTED_PAGE.project.toString().equals(requestedPage)) {
            projectController.showProject(request, response);
        } else if (REQUESTED_PAGE.investment.toString().equals(requestedPage)) {
            investmentController.showInvestment(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PAGE_NOT_FOUND);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedAction = request.getParameter(REQUESTED_ACTION_PARAM_NAME);
        if (REQUESTED_ACTION.add_question.toString().equals(requestedAction)) {
            projectController.addQuestion(request, response);
        } else if (REQUESTED_ACTION.add_investment.toString().equals(requestedAction)) {
            investmentController.addInvestment(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.ACTION_NOT_FOUND);
        }
    }

}
