package ua.com.goit.java5.dm.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.java5.dm.kickstarter.mvc.ModelAndView;
import ua.com.goit.java5.dm.kickstarter.mvc.controller.MainPageController;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageServlet implements DoGetServlet {

    private MainPageController mainPageController;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ModelAndView modelAndView = mainPageController.index();
        req.setAttribute("model", modelAndView.getModel());
        req.getRequestDispatcher(modelAndView.getView()).forward(req, resp);
    }

    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }
}
