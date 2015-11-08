package com.kickstarter.view;
import java.util.Scanner;

public class InPutConsole implements In{
	
	public int readInput() {
		return new Scanner(System.in).nextInt();
	}  
}