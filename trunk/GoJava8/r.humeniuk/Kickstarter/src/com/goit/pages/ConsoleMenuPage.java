package com.goit.pages;

import com.goit.io.PageReaderImpl;
import com.goit.keyboard.ConsoleInputHendler;

public class ConsoleMenuPage implements PageWriter {

	PageReaderImpl pageReaderImpl;
	ConsoleInputHendler consoleInputHendler;
	ConsoleCategoryPage consoleCategoryPage;
	ConsolePagePath consolePagePath;
	private String menuFilePath;
	private String quoteFilePath;

	public ConsoleMenuPage(String menuFilePath, String quoteFilePath) {
		pageReaderImpl = new PageReaderImpl();
		consoleInputHendler = new ConsoleInputHendler();
		consoleCategoryPage = new ConsoleCategoryPage();
		consolePagePath = ConsolePagePath.getInstance();
		this.menuFilePath = menuFilePath;
		this.quoteFilePath = quoteFilePath;
	}

	@Override
	public void showPage() {
		pageReaderImpl.showMenu(menuFilePath, quoteFilePath);
		int numberPage = consoleInputHendler.itemCaregoryNumber();
		exitMenu(numberPage);
		consolePagePath.setNumberCategory(numberPage);
		consoleCategoryPage.setNumberPage(numberPage);
		consoleCategoryPage.showPage();
	}

	private void exitMenu(int numberPage) {
		if (numberPage == 0) {
			System.out.println("See you later:)");
			System.exit(0);
		}
	}

}
