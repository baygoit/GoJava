//package com.go_java4.alex_mirn.input_output.pages;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Stack;
//
//import com.go_java4.alex_mirn.dao.Dao;
//import com.go_java4.alex_mirn.data_containers.Repository;
//import com.go_java4.alex_mirn.input_output.io.ConsoleIO;
//import com.go_java4.alex_mirn.input_output.io.IO;
//
//public class PageDispatcher {
//	State state = State.CATEGORIES_PAGE;
//	private IO io;
//	public Dao repository;
//	public AbstractPage ipage;
//	private static Map<String, String> choice = new HashMap<String, String>();
//	private static Stack<Page> pagesStack = new Stack<Page>();
//	private static boolean goBack = false;
//	
//	public PageDispatcher(IO io, Dao repository) {
//		this.io = io;
//		this.repository = repository;
//		this.ipage = new CategoriesPage(io, repository);
//	}
//
////	while (true) {
//		
//	public void run() throws IOException {
//		try {
//			ipage.run(choice);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//			
////		while (true) {
////			switch (state) {
////		        case CATEGORIES_PAGE:
////				try {
////					System.out.println("PageDispatcher.run");
////					ipage.run(choice);
////				} catch (SQLException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////		        	if (goBack == true) {
////		        		ipage = pagesStack.pop();
////		        		goBack = false;
////		        	} else {
////		        		ipage = new CategoriesPage(io, repository);
////		        	}
////		        	ipage.run(choice);
////		        	state = ipage.makeChoice(choice);
////		        	if (state == State.PROJECTS_PAGE) {
////		        		pagesStack.push(ipage);
////		        	}
////		        break;
////		        case PROJECTS_PAGE:
////		        	if (goBack == true) {
////		        		ipage = pagesStack.pop();
////		        		goBack = false;
////		        	} else {
////		        		ipage = new ProjectsPage(io, repository);
////		        	}
////		        	ipage.run(choice);
////		        	state = ipage.makeChoice(choice);
////		        	if (state == State.CATEGORIES_PAGE) {
////		        		goBack = true;
////		        	}
////		        	if (state == State.ONE_PROJECT_PAGE) {
////		        		pagesStack.push(ipage);
////		        	}
////		        break;
////		        case ONE_PROJECT_PAGE:
////		        	if (goBack == true) {
////		        		ipage = pagesStack.pop();
////		        		goBack = false;
////		        	} else {
////		        		ipage = new OneProjectPage(io, repository);
////		        	}
////		        	ipage.run(choice);
////		        	state = ipage.makeChoice(choice);
////		        	if (state == State.PROJECTS_PAGE) {
////		        		goBack = true;
////		        	}
////		        break;
////			}
////		}
//	}
//}
//
//
//
//














package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.input_output.io.ConsoleIO;
import com.go_java4.alex_mirn.input_output.io.IO;

public class PageDispatcher {
	State state = State.CATEGORIES_PAGE;
	private IO io;
	private Dao repository;
	private AbstractPage ipage;
	private static Map<String, String> choice = new HashMap<String, String>();
	private static Stack<AbstractPage> pagesStack = new Stack<AbstractPage>();
	private static boolean goBack = false;
	
	public PageDispatcher(IO io, Dao repository) {
		this.io = io;
		this.repository = repository;
	}
		
	public void run() throws IOException, SQLException {
			switch (state) {
		        case CATEGORIES_PAGE:
		        	if (goBack == true) {
		        		ipage = pagesStack.pop();
		        		goBack = false;
		        	} else {
		        		ipage = new CategoriesPage(io, repository);
		        	}
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        	if (state == State.PROJECTS_PAGE) {
		        		pagesStack.push(ipage);
		        	}
		        break;
		        case PROJECTS_PAGE:
		        	if (goBack == true) {
		        		ipage = pagesStack.pop();
		        		goBack = false;
		        	} else {
		        		ipage = new ProjectsPage(io, repository);
		        	}
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        	if (state == State.CATEGORIES_PAGE) {
		        		goBack = true;
		        	}
		        	if (state == State.ONE_PROJECT_PAGE) {
		        		pagesStack.push(ipage);
		        	}
		        break;
		        case ONE_PROJECT_PAGE:
		        	if (goBack == true) {
		        		ipage = pagesStack.pop();
		        		goBack = false;
		        	} else {
		        		ipage = new OneProjectPage(io, repository);
		        	}
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        	if (state == State.PROJECTS_PAGE) {
		        		goBack = true;
		        	}
		        break;
			}
	}
}
