package goit.iavorskyi.controller;

import goit.iavorskyi.io.Streamer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Creator")
public class Creator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Creator() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Streamer.write(request.getParameter("author") + " " + request.getParameter("text"));
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(request.getParameter("author") + " + "	+ request.getParameter("text"));
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=UTF-8");
			response.sendRedirect("");
		}

	}

}
