package belskii.artem.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoGetServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
