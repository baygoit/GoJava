package ua.com.goit.gojava1.lslayer.hackit2.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.ActorFactory;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorDAO;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

/**
 * Servlet implementation class ActorMaintainer
 */
public class ActorMaintainer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActorMaintainer() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        ActorDAO dao = new ActorDAO(!this.getServletContext().getServerInfo()
                .equals("Apache Tomcat/7.0.57"));
        request.setAttribute("gamers", dao.loadAll());
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String deleteParameter = request.getParameter("delete");
        String createParameter = request.getParameter("create");
        ActorDAO dao = new ActorDAO(!this.getServletContext().getServerInfo()
                .equals("Apache Tomcat/7.0.57"));
        if (deleteParameter != null && deleteParameter.equals("yes"))
            for (Actor gamer : dao.loadAll()) {
                String deleteParameterString = request.getParameter(gamer
                        .getName());
                if (deleteParameterString != null
                        && deleteParameterString.equals("on")) {
                    try {
                        dao.delete(gamer);
                    } catch (HackitIOException e) {
                        // I need to do something here
                        // But not now
                    }
                }
            }
        if (createParameter != null && createParameter.equals("yes")) {
            String skills[] = null;
            ActorFactory actorFactory = new ActorFactory();
            String name = null;
            PrintWriter out = response.getWriter();
            name = request.getParameter("name");
            actorFactory.setActorName(name);
            if (request.getParameter("skills") != null) {
                skills = request.getParameter("skills").split(";");
            }
            actorFactory.addSkillsArray(skills);
            try {
                dao.save(actorFactory.createActor());
            } catch (HackitIOException e) {
                out.print(e.getMessage());
            }

        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("actors");
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

}
