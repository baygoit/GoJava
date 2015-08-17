package com.tyomsky.kickstarter.servlet;

import com.tyomsky.kickstarter.dao.*;
import com.tyomsky.kickstarter.model.Project;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


public class MainServlet extends HttpServlet {

    private String getAction(HttpServletRequest req) {
        String result;
        String reqURI = req.getRequestURI();
        result = reqURI.substring(req.getContextPath().length(), reqURI.length());
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = getAction(req);
        if (action.equals("/")) {
            showMainPage(req, resp);
        } else if (action.startsWith("/projects")) {
            showProjectsPage(req, resp);
        } else if (action.startsWith("/project")) {
            showProjectPage(req, resp);
        } else {
            // 404
        }

    }

    private void showMainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = getDataSource();
        QuoteDAO quoteDAO = new QuoteDAOImpl(dataSource);
        CategoryDAO categoryDAO = new CategoryDAOImpl(dataSource);

        req.setAttribute("quote", quoteDAO.get(1));
        req.setAttribute("categories", categoryDAO.getAll());
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    private DataSource getDataSource() {
        ServletContext servletContext = getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        if (dataSource == null) {
            Context jndiContext;
            try {
                jndiContext = new InitialContext();
                dataSource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/KickstarterDS");
            } catch (NamingException e) {
                throw new RuntimeException("resource jdbc/KickstarterDS is not found!", e);
            }
            servletContext.setAttribute("dataSource", dataSource);
        }
        return dataSource;
    }

    private void showProjectsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = getDataSource();
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        CategoryDAO categoryDAO = new CategoryDAOImpl(dataSource);
        ProjectDAO projectDAO = new ProjectDAOImpl(dataSource);
        List<Project> projectsByCategory = projectDAO.getByCategoryId(categoryId);
        req.setAttribute("category", categoryDAO.get(categoryId));
        req.setAttribute("projects", projectsByCategory);
        req.getRequestDispatcher("projects.jsp").forward(req, resp);
    }

    private void showProjectPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = getDataSource();
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        ProjectDAO projectDAO = new ProjectDAOImpl(dataSource);
        Project project = projectDAO.getById(projectId);
        req.setAttribute("project", project);
        req.getRequestDispatcher("project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if (action.startsWith("/payment")) {
            makePayment(req, resp);
        } else {
            // 404
        }
    }

    private void makePayment(HttpServletRequest req, HttpServletResponse resp) {
        DataSource dataSource = getDataSource();
        ProjectDAO projectDAO = new ProjectDAOImpl(dataSource);
        Project project = projectDAO.getById(Integer.parseInt(req.getParameter("projectId")));
        int paymentSum = req.getParameter("sum").isEmpty()? 0 : Integer.parseInt(req.getParameter("sum"));
        project.setBalance(project.getBalance()+ paymentSum);
        projectDAO.update(project);
        try {
            resp.sendRedirect("project?projectId=" + req.getParameter("projectId"));
        } catch (IOException e) {
            throw new RuntimeException("wrong redirection page",e);
        }
    }

}
