package com.gmail.grezin.v;
/*
 * Task 1: Write program that request your name and
 * print "your name" Hello world!  
 */
import java.util.Scanner;

public class printHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Please input your name");
		System.out.println(scan.nextLine() + ", Hello world!");
		scan.close();
	}

}
