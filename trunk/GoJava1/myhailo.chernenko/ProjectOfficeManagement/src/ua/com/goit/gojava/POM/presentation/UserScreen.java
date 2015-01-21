package ua.com.goit.gojava.POM.presentation;

import java.util.Scanner;

import ua.com.goit.gojava.POM.dataModel.DataObject;

public class UserScreen implements java.io.Closeable {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void close() {
		
		scanner.close();
		
	}
	
	public void showString(String info) {
		
		System.out.println(info);
		
	}
	
	public void showDataObject(DataObject obj) {
		
		System.out.println(obj.toString());
		
	}

	public String getString() {
		
		String info = "";
		
		if(scanner.hasNextLine()) {		
			info = scanner.nextLine();		
		}
		
		return info;
		
	}

}
