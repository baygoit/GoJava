package ua.com.goit.gojava2.vova.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String doIt(HttpServletRequest req, HttpServletResponse resp);
}
