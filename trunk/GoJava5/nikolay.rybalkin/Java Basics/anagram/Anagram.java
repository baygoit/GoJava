package anagram;

import java.util.Scanner;

public class Anagram {
	
	 public static void main(String[] args) {

		 System.out.println("Enter the console words separated by a space, then press enter: ");
		 Scanner scanConsole = new Scanner(System.in);
         String line = scanConsole.nextLine();        
         String[] array = line.split(" ");   
         
         for(int i = 0; i <= array.length - 1; i++) {
	         System.out.print(new StringBuilder(array[i]).reverse().toString());
	         System.out.print(" ");
	     }
	 }
}
