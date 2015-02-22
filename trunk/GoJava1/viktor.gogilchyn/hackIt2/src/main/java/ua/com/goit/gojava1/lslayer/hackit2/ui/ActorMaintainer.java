package ua.com.goit.gojava1.lslayer.hackit2.ui;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.ActorFactory;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorDAO;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitEcxeptionForUI;
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

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ActorDAO dao = new ActorDAO();

        try {
            request.setAttribute("gamers", dao.loadAll());
        } catch (HackitEcxeptionForUI e) {
            request.setAttribute("error", e.getMessage());
        }
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String deleteParameter = request.getParameter("delete");
        String createParameter = request.getParameter("create");
        String editParameter = request.getParameter("edit");
        ActorDAO dao = new ActorDAO();
        if (deleteParameter != null && deleteParameter.equals("yes"))
            try {
                for (Actor gamer : dao.loadAll()) {
                    String deleteParameterString = request.getParameter(gamer
                            .getName());
                    if (deleteParameterString != null
                            && deleteParameterString.equals("on")) {
                        try {
                            dao.delete(gamer);
                        } catch (HackitIOException e) {
                            request.setAttribute("error", e.getMessage());
                        }
                    }
                }
            } catch (HackitEcxeptionForUI e) {
                request.setAttribute("error", e.getMessage());
            }
        if (createParameter != null && createParameter.equals("yes")) {
            String skills[] = null;
            ActorFactory actorFactory = new ActorFactory();
            String name = null;
            name = request.getParameter("name");
            actorFactory.setActorName(name);
            if (request.getParameter("skills") != null) {
                skills = request.getParameter("skills").split(";");
            }
            actorFactory.addSkillsArray(skills);
            try {
                dao.save(actorFactory.createActor());
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            }

        }
        if (editParameter != null && editParameter.equals("yes")) {
            Actor editedGamer = null;
            String nameForEdit = request.getParameter("name_for_edit");
            try {
                editedGamer = dao.fromFile(nameForEdit);
                request.setAttribute("edit_name", editedGamer.getName());
                StringBuilder builder = new StringBuilder();
                Map<String, Integer> skills = editedGamer.getSkills();
                for (Map.Entry<String, Integer> entry : skills.entrySet()) {
                    builder.append(entry.getKey());
                    builder.append(";");
                }
                request.setAttribute("edit_skills", builder.toString());
            } catch (HackitIOException e) {
                request.setAttribute("error", e.getMessage());
            }
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
        // request.getRequestDispatcher("actors").forward(request, response);
    }
}
