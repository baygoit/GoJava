package com.goit.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.goit.logic.Menu;

public class MenuFileReader {
	public static final String EXIT = "exit";
	Menu menu;
	File fileMenu;
	File fileQuote;

	MenuFileReader(String filePath, String filePathQuote) {
		fileMenu = new File(filePath);
		fileQuote = new File(filePathQuote);
		menu = new Menu();
	}

	private void setQuote() throws IOException {
		BufferedReader buffereadReader = new BufferedReader(new FileReader(fileQuote));	
		menu.setQuote(buffereadReader.readLine());
		buffereadReader.close();
	}

	private void setCategories() throws IOException {
		BufferedReader buffereadReader = new BufferedReader(new FileReader(fileMenu));
		String line;
		menu.addCategory(EXIT);
		while ((line = buffereadReader.readLine()) != null) {
			menu.addCategory(line);
		}
		buffereadReader.close();
	}

	public Menu getMenu() throws IOException {
		setQuote();
		setCategories();
		return menu;
	}

}
