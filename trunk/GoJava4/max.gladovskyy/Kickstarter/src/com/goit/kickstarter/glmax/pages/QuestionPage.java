package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.enteties.Entetie;

public class QuestionPage extends Page {

	public QuestionPage(Entetie entetie) {
		super(null);
	}

	@Override
	protected void prepareFormatedPage() {
		System.out.println("Enter your question please and press enter.");		
	}


}
