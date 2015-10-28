package com.goit.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.goit.kickstarter.dao.FaqDAO;
import com.goit.kickstarter.model.FAQ;

public class FaqAction {

	@Autowired
	private FaqDAO faqDao;

	private List<FAQ> faqs;
	private int id;
	private FAQ faq;
	private FAQ newFaq;
	private String message;

	public String execute() {
		faqs = faqDao.getFaq(id);
		return "success";
	}
	
	public String addFaq() {
		if("".equals(newFaq.getQuestion())){
			message = "please enter your question!";
			faqs = faqDao.getFaq(id);
			return "fail";
		}
		message="thank you for your question!";
		newFaq.setProjectId(id);
		faqDao.addFaq(newFaq);
		return execute();
	}

	public List<FAQ> getFaqs() {
		return faqs;
	}

	public void setFaqs(List<FAQ> faqs) {
		this.faqs = faqs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FAQ getNewFaq() {
		return newFaq;
	}

	public void setNewFaq(FAQ newFaq) {
		this.newFaq = newFaq;
	}

}
