package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/pay")
public class RewardSelectionController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RewardDAO rewardDAO;
    private ProjectDAO projectDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("id"));

        List<Reward> rewards = rewardDAO.getByProject(projectId);
        if (!rewards.isEmpty()) {
        	request.setAttribute("project", projectDAO.get(projectId));
        	request.setAttribute("rewards", rewards);
            request.getRequestDispatcher("view/Rewards.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("view/Payment.jsp?project="+projectId).forward(request, response);
		}
		
    }
    
    @Override
    public void init() throws ServletException {
    	StorageFactory factory = (StorageFactory) getServletContext().getAttribute(ContextInitializer.STORAGE_FACTORY);
        rewardDAO = factory.getRewardDAO();
        projectDAO = factory.getProjectDAO();
    }

}
