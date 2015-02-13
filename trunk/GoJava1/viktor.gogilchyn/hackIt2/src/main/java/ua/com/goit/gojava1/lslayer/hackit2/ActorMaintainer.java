package ua.com.goit.gojava1.lslayer.hackit2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava1.lslayer.hackit2.actor.ActorFactory;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorDAO;

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
        GameSession gameSession = GameSession.getInstance();
        request.setAttribute("gamers", gameSession.getGamers());
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String skills [] = null;
        String name = null;
        ActorDAO dao = new ActorDAO(!this.getServletContext().getServerInfo().equals("Apache Tomcat/7.0.57"));
        name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        if (request.getParameter("skills") != null) {
            skills = request.getParameter("skills").split(";");
        }            
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            dao.save(ActorFactory.createActorWithSkills(name, skills));
        } catch (Exception e) {
            out.println(e.getMessage());
        }
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
        // TODO Auto-generated method stub
    }

}
