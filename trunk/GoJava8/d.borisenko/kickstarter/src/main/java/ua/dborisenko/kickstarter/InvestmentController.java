package ua.dborisenko.kickstarter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.dao.InvestmentDao;
import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.dao.RewardDao;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class InvestmentController {

    static final String REWARDS_ATTR_NAME = "rewards";
    static final String PROJECT_ATTR_NAME = "project";
    static final String CUSTOM_AMOUNT_PARAM_NAME = "custom_amount";
    static final String AMOUNT_PARAM_NAME = "amount";
    static final String CARD_NUMBER_PARAM_NAME = "card_number";
    static final String CARDHOLDER_NAME_PARAM_NAME = "cardholder_name";
    static final String PROJECT_ID_PARAM_NAME = "project_id";
    static final String PROJECT_OUT_URL = "?page=project&id=";
    static final String INVESTMENT_JSP_PATH = "/WEB-INF/jsp/investment.jsp";
    @Autowired
    private InvestmentDao investmentDao;
    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private ProjectDao projectDao;

    void addInvestment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter(PROJECT_ID_PARAM_NAME));
            Project project = projectDao.getById(projectId);
            Investment investment = new Investment();
            investment.setProject(project);
            investment.setCardHolderName(request.getParameter(CARDHOLDER_NAME_PARAM_NAME));
            investment.setCardNumber(request.getParameter(CARD_NUMBER_PARAM_NAME));
            if (Integer.valueOf(request.getParameter(AMOUNT_PARAM_NAME)) == 0) {
                investment.setAmount(Integer.valueOf(request.getParameter(CUSTOM_AMOUNT_PARAM_NAME)));
            } else {
                investment.setAmount(Integer.valueOf(request.getParameter(AMOUNT_PARAM_NAME)));
            }
            if (investment.getAmount() <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NEGATIVE_AMOUNT);
                return;
            }
            investmentDao.add(investment);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }

    void showInvestment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter(PROJECT_ID_PARAM_NAME));
            Project project = projectDao.getById(projectId);
            rewardDao.getAllForProject(project);
            request.setAttribute(PROJECT_ATTR_NAME, project);
            request.setAttribute(REWARDS_ATTR_NAME, project.getRewards());
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(INVESTMENT_JSP_PATH);
            dispatcher.forward(request, response);
        } catch (EmptyResultDataAccessException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PROJECT_NOT_FOUND);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }
}
