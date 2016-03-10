package com.goit.launcher;

import com.goit.keyboard.PressHandler;
import com.goit.pages.ConsoleMenuPage;
import com.goit.pages.PageWriter;

public class Main {

	public static void main(String[] args) {
		//PressHandler ph = new PressHandler("data/menu.txt", "data/quote.txt");
		//ph.openMenu();
		//ph.chooseCategory();
		
		PageWriter menuPage = new ConsoleMenuPage(FilePathHolder.MENU_PATH, FilePathHolder.QUOTE_PATH);
		menuPage.showPage();
		
	}

}
