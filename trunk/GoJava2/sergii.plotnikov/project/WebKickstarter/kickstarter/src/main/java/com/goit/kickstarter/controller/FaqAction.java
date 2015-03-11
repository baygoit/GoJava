package com.goit.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goit.kickstarter.dao.FaqDAO;
import com.goit.kickstarter.model.FAQ;

public class FaqAction implements Action {
	
	private FaqDAO faqDao;
	
	public FaqAction(FaqDAO faqDao){
		this.faqDao=faqDao;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) {
		int projectId = Integer.valueOf(req.getParameter("projectId"));
		int categoryId=Integer.valueOf(req.getParameter("categoryId"));

		List<FAQ> faq = faqDao.getFaq(projectId);

		req.setAttribute("faq", faq);
		req.setAttribute("projectId", projectId);
		req.setAttribute("categoryId", categoryId);
		
		return "faq.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) {
		String question = req.getParameter("question");

		if ("".equals(question)) {
			req.setAttribute("error", "Type your question!");
			return doGet(req, resp);
		} else {
			faqDao.createFaq(new FAQ(question, Integer.valueOf(req.getParameter("projectId"))));
			return doGet(req, resp);
		}
	}

}
