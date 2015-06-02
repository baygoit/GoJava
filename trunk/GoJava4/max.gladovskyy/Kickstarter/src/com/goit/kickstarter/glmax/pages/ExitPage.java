package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.view.Output;

public class ExitPage extends Page {

	public ExitPage(Entetie entetie) {
		super(null);
	}

	@Override
	public void show(Output printer) {
		super.show(printer);
		System.exit(0);
	}

	@Override
	protected void prepareFormatedPage() {
		formatedPage.add("");
		formatedPage.add("Good bye!");
		formatedPage.add("See you next time!");
	}
	


}
