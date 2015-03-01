package ua.goit.goitjava.kickstarterInMemory;

import java.util.Scanner;

public class Input {
	public int scanInt(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public String scanLine(){
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

}
