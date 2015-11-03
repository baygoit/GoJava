/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/30/15
 */
@WebServlet(urlPatterns = "login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        session.setAttribute("user", user);
        session.setAttribute("pass", pass);
        logger.info("you are try to login with user: " + user + " and password: " + pass);
        resp.sendRedirect("admin/admin.jsp");
        }
}
