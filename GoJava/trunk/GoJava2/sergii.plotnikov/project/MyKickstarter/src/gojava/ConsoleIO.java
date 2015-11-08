package gojava;

import gojava.Interface.IO;

import java.util.Scanner;

public class ConsoleIO implements IO{
	
	@Override
	public int input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	@Override
	public String stringInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	@Override
	public void out(String message){
		System.out.println(message);
	}

}
