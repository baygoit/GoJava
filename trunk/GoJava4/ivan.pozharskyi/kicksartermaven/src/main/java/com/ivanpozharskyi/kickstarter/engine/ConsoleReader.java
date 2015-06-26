package com.ivanpozharskyi.kickstarter.engine;

import java.util.Scanner;

public class ConsoleReader implements Readable {
	private Scanner scanner;

	@Override
	public int read() {
		scanner = new Scanner(System.in);
		int result = 0;
		while(true){
			
			try{
				
				result = Integer.parseInt(scanner.nextLine());				
				return result;
			}
			catch (IllegalArgumentException ex){
				System.out.println("Try again with numbers");
			}
		}	
		
		
			
		
	}

}
