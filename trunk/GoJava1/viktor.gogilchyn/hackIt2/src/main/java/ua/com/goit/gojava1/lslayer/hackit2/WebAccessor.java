package ua.com.goit.gojava1.lslayer.hackit2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava1.lslayer.hackit2.GameSession;

/**
 * Servlet implementation class WebAccessor
 */
public class WebAccessor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebAccessor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        GameSession gameSession = GameSession.getInstance();
//        gameSession.addHumanGamer("First one");
//        gameSession.addHumanGamer("Second two");
        request.setAttribute("gamers", gameSession.getGamers());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        // Map<String, String[]> parameterMap = request.getParameterMap();
        // response.setContentType("text/html");
        // response.setCharacterEncoding("utf-8");
        // ServletOutputStream out = response.getOutputStream();
        // out.println("<h1>It's me!</h1>");
        // for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
        // out.print("<p>");
        // out.print(entry.getKey() + " - " + entry.getValue().toString());
        // out.print("</p>");
        // }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
