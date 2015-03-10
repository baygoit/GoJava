package ua.com.goit.gojava1.lslayer.hackit2.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.goit.gojava1.lslayer.hackit2.actor.ActorFactory;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorJDBCDAO;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

/**
 * Servlet implementation class ActorMaintainer
 */
public class ActorMaintainer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(ActorMaintainer.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActorMaintainer() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET received");
        @SuppressWarnings("resource")
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");
        ActorJDBCDAO dao = null;
        try {
            dao = (ActorJDBCDAO) ctx.getBean("getDAO");
        } catch (Exception e1) {
            logger.error("Spring didn't privided DAO", e1);
            e1.printStackTrace();
        }
        String idParameter = request.getParameter("view_id");
        if (idParameter != null) {
            try {
                logger.info("ID recived: " + idParameter);
                long detailsId = Long.parseLong(idParameter);
                request.setAttribute("details", dao.load(detailsId));
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
                request.setAttribute("gamers", dao.loadAll());
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
        @SuppressWarnings("resource")
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");
        ActorJDBCDAO dao = null;
        try {
            dao = (ActorJDBCDAO) ctx.getBean("getDAO");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (deleteParameter != null && deleteParameter.equals("yes") && id > 0)
            try {
                dao.delete(id);
            } catch (HackitIOException e) {
                request.setAttribute("error", e.getMessage());
            }
        if (createParameter != null && createParameter.equals("yes")) {
            String skills[] = null;
            ActorFactory actorFactory = new ActorFactory();
            String name = null;
            String[] attributes = null;
            name = request.getParameter("name");
            actorFactory.setActorName(name);
            if (request.getParameter("skills") != null) {
                skills = request.getParameter("skills").split("\r\n");
            }
            if (request.getParameter("attributes") != null) {
                attributes = request.getParameter("attributes").split("\r\n");
            }
            actorFactory.addSkillsArray(skills);
            try {
                dao.save(actorFactory.createActor());
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            }
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}
