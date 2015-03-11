package com.goit.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	String doGet(HttpServletRequest req, HttpServletResponse resp);
	
	String doPost(HttpServletRequest req, HttpServletResponse resp);

}
