package ua.goit.goitjava.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {
	
	@Override
	public void print(String text){
		System.out.println(text);
	}
	
	@Override
	public String scan(){
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

}
