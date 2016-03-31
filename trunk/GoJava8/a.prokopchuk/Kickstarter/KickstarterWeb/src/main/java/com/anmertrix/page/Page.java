package com.anmertrix.page;

import javax.servlet.http.HttpServlet;

import com.anmertrix.ViewPage;

public abstract class Page extends HttpServlet {
	
 	private static final long serialVersionUID = 1L;
 	
	protected ViewPage page = new ViewPage();

}
