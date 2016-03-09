package com.goit.pages;

import com.goit.io.PageReaderImpl;
import com.goit.keyboard.ConsoleInputHendler;
import com.goit.launcher.FilePathHolder;

public class ConsoleCategoryPage implements PageWriter {
	private int numberPage;
	PageReaderImpl PageReaderImpl;
	ConsoleInputHendler consoleInputHendler;
	ConsolePagePath consolePagePath;

	ConsoleCategoryPage() {
		consoleInputHendler = new ConsoleInputHendler();
		PageReaderImpl = new PageReaderImpl();
	}

	@Override
	public void showPage() {
		numberPage = consoleInputHendler.itemProjectNumber();
		 backToMenu();
		 consolePagePath.setNumberProject(numberPage);
		 PageReaderImpl.showCategory(numberPage);
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public int getNumberPage() {
		return numberPage;
	}
	
	private void backToMenu(){
		if (numberPage == 0) {
			PageReaderImpl.showMenu(FilePathHolder.MENU_PATH, FilePathHolder.QUOTE_PATH);
		}
	}

}
