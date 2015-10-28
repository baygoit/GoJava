package ua.com.goit.gojava.andriidnikitin;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{	
			
		try(Scanner inputSource = new Scanner(System.in)){			
			DivisionUnit divisionUnit = new DivisionUnit();
			System.out.println ("Type input numbers:"
					+ "");
			System.out.println ("dividend = ");	
			int dividend = getIntNumber(inputSource);
			System.out.println("divider = ");
			int divider = getIntNumber(inputSource);
			divisionUnit.longDivision(dividend, divider);
			String result = divisionUnit.getResult();
			System.out.println("result = " + result);
			List<StringBuilder> log = divisionUnit.getLog();
			printList(log, System.out);
		} catch (IllegalArgumentException e){
			System.out.println("Wrong input!");
		}
	}
		
	private static int getIntNumber(Scanner inputSource) 
			throws NumberFormatException{	
		
		String input = inputSource.nextLine();
		return Integer.parseInt(input);
	}
	
	private static void printList(List<StringBuilder> list, PrintStream stream) {
		
		for (int i = 0; i< list.size(); i++)
			stream.println(list.get(i));
	}
}
