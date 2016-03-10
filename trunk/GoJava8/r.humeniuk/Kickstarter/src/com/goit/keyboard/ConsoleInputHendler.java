package com.goit.keyboard;

import java.util.Scanner;

import com.goit.io.PageReaderImpl;

public class ConsoleInputHendler {
	Scanner scanner;
	PageReaderImpl pageReaderImpl;

	public ConsoleInputHendler() {
		pageReaderImpl = new PageReaderImpl();
	}

	public int itemProjectNumber() {
		scanner = new Scanner(System.in);
		try {
			
			Integer item = new Integer(scanner.next());
			pageReaderImpl.setProjectList(item);
			return item;
		} catch (Exception e) {
			System.out.println("invalid input");
			itemProjectNumber();
		} finally {
			//scanner.close();
		}
		return 0;
	}

	public int itemCaregoryNumber() {
		try {
			scanner = new Scanner(System.in);
			Integer item = new Integer(scanner.next());
			// pageReaderImpl.setCategoryList(item);
			return item;
		} catch (Exception e) {
			System.out.println("invalid input");
			itemCaregoryNumber();
		} finally {
			//scanner.close();
		}
		return 0;
	}

}
