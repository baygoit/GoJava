package anagram;


import java.io.*;
import java.util.*;

public class Anagram {
    
    public static void main(String[] args) throws IllegalArgumentException {
    	while (true) {
	    	Scanner in = new Scanner(System.in);
	        System.out.println("Enter a sentence:");
	        String input = in.nextLine();
	        
	        if (input.trim().equals("exit")) {
	        	System.out.println(input);
	        	System.exit(0);
	        } else {
		        Reverse reversedWord = new Reverse(input);
		        reversedWord.check();
		        System.out.println(reversedWord.change());
	        }
    	}
    }
}