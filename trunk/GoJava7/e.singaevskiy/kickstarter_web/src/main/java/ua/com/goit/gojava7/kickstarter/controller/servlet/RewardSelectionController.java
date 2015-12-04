package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;
import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/pay")
public class RewardSelectionController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RewardDAO rewardDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("id"));
        
        List<Reward> rewards = rewardDAO.getByProject(projectId);
        
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < rewards.size();) {
            Reward reward = rewards.get(i++);
            body.append(String.format("<a href=./payment?project=%s&reward=%s&amount=%s>%s</a>",
                    projectId,
                    reward.getId(),                   
                    reward.getPledgeSum(),
                    "\n" + i + ". Pay $" + reward.getPledgeSum() + " : " + reward.getDescription()));            
        }
        
        body.append(String.format("<a href=./payment?project=%s%s>%s</a>",
                projectId,
                "",
                "\n Pay any amount you like")); 

        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle("Select your reward");
        htmlPageWriter.setBody(body.toString());
        response.getWriter().print(htmlPageWriter.prepare());
    }
    
    @Override
    public void init() throws ServletException {
    	StorageFactory factory = (StorageFactory) getServletContext().getAttribute(ContextInitializer.STORAGE_FACTORY);
        rewardDAO = factory.getRewardDAO();

    }

}
