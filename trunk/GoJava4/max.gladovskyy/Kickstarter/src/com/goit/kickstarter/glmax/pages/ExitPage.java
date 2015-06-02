package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.view.Output;

public class ExitPage extends Page {

	@Override
	public void show(Output printer) {
		System.out.println("");
		System.out.println("Good bye!");
		System.out.println("See you next time!");
		System.exit(0);
	}
	


}
