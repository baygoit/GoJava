package tyomsky.kickstarter.servlet;

import tyomsky.kickstarter.model.QuoteGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome to Kickstarter!<h1>");
        out.println("<h2>"+ new QuoteGenerator(new Random()).getQuote()+"<h2>");
    }

}
