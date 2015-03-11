package ua.com.sas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String getJsp(HttpServletRequest req, HttpServletResponse resp);
}
