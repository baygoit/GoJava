package ua.com.goit.gojava.myshko;

import java.util.Scanner;

class UserScreen implements java.io.Closeable {
	
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
