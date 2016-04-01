package com.anmertrix;

import java.io.IOException;

import com.anmertrix.page.CategoriesPage;

public class Kickstarter {

	public static void main(String[] args) throws IOException {
		new Kickstarter().run();
	}

	private void run() {
		ViewPage viewPage = new ViewPage(new ConsoleIO());
		viewPage.initData();
		viewPage.setPage(new CategoriesPage());
		while (!viewPage.isExit()) {
			viewPage.viewPage();
		}
	}
}
