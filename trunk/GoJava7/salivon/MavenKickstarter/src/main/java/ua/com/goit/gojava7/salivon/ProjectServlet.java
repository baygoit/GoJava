package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {

    Project project;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initField(request);
        HttpSession session = request.getSession();
        session.setAttribute("idProject", project.getId());
        request.setAttribute("project", project);
        RequestDispatcher dispatcher = request.getRequestDispatcher("project.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void initField(HttpServletRequest request) {
        DataType dataType = (DataType) getServletContext().getAttribute("mode");
        String param = request.getParameter("id");
        int idProject;
        if (param == null) {
            idProject = ((int) request.getSession().getAttribute("idProject"));
        } else {
            idProject = Integer.parseInt(request.getParameter("id"));

        }
        project = DaoFactory.getProjectDao(dataType).getProject(idProject);
    }

}
