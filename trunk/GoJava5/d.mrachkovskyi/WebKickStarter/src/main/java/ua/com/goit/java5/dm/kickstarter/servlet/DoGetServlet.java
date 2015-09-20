package ua.com.goit.java5.dm.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DoGetServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
