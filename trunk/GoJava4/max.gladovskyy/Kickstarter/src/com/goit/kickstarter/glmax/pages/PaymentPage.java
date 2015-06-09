package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.enteties.Entetie;

public class PaymentPage extends Page {

	public PaymentPage(Entetie entetie) {
		super(entetie);
		currentMenuLevel = Position.Payment;
	}

	@Override
	protected void prepareFormatedPage() {

		formatedPage.add("You have multiple variants of payment:");
		fillMenu();
		formatedPage.add("");
		formatedPage.add("0) Exit");
		formatedPage.add("");
	}

}
