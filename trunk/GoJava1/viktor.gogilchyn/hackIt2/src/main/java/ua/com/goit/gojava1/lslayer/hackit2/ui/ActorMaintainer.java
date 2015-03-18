package ua.com.goit.gojava1.lslayer.hackit2.ui;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.goit.gojava1.lslayer.hackit2.domain.GameSession;
import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitIOException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.ActorFactory;

/**
 * Servlet implementation class ActorMaintainer
 */
public class ActorMaintainer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(ActorMaintainer.class);
    private GameSession session = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActorMaintainer() {
        super();
        this.session = GameSession.getInstance();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET received");
        String idParameter = request.getParameter("view_id");
        if (idParameter != null) {
            try {
                logger.info("ID recived: " + idParameter);
                long detailsId = Long.parseLong(idParameter);
                request.setAttribute("details", session.getRegisteredActor(detailsId));
            } catch (NumberFormatException e) {
                logger.warn("Non numeric ID" + idParameter);
                request.setAttribute("error", "Id should be number");
            } catch (HackitIOException e) {
                logger.error("Loading failed", e);
                request.setAttribute("error", e.getMessage());
            }
            request.getRequestDispatcher("details.jsp").forward(request, response);
        } else {
            try {
                logger.info("Trying to load all actors");
                request.setAttribute("gamers", session.getRegisteredGamers());
            } catch (HackitIOException e) {
                logger.error("Loading failed", e);
                request.setAttribute("error", e.getMessage());
            }
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String deleteParameter = request.getParameter("delete");
        String createParameter = request.getParameter("create");
        String idParameter = request.getParameter("delete_id");
        long id = -1;
        if (idParameter != null) {
            try {
                id = Long.parseLong(idParameter);
            } catch (NumberFormatException e) {
                request.setAttribute("error", e.getMessage());
            }
        }
        if (deleteParameter != null && deleteParameter.equals("yes") && id > 0)
            try {
                session.deleteRegisteredActor(id);
            } catch (HackitIOException e) {
                request.setAttribute("error", e.getMessage());
            }
        if (createParameter != null && createParameter.equals("yes")) {
            java.util.List<String> skills = null;
            ActorFactory actorFactory = new ActorFactory();
            String name = null;
            String[] attributes = null;
            name = request.getParameter("name");
            actorFactory.setActorName(name);
            if (request.getParameter("skills") != null) {
                skills = Arrays.asList(request.getParameter("skills").split("\r\n"));
            }
            if (request.getParameter("attributes") != null) {
                attributes = request.getParameter("attributes").split("\r\n");
            }
            try {
                session.registerActor(actorFactory.createActor());
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            }
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}
