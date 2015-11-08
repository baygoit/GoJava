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
 * @version 11/2/15
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        logger.info("you are logged out");
        resp.sendRedirect("/admin/admin.jsp");
    }
}
