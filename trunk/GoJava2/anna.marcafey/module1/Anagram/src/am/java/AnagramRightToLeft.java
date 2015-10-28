package am.java;

import java.util.Scanner;

public class AnagramRightToLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner in = new Scanner (System.in);
	
	System.out.println ("Enter a string of words");
	System.out.println ("For exsample: Today is a sunny day");
	
	String enteredText = in.nextLine ();
	in.close ();
	
	int n = enteredText.length ();
	
	Character[] ArrayOfWords = new Character [n];
	
	for (int i=0; i<n; i++) {
		char letter = enteredText.charAt(i);
		ArrayOfWords[i] = letter;
	}
	
	int k = 0;
	for (int i=0; i<n; i++) {
		if (ArrayOfWords[i] == ' ') {
			for (int j=i-1; j>=k; j--) System.out.print(ArrayOfWords[j]);
			k = i;
		}
		if (i == n-1) {
			for (int j=i; j>=k; j--) System.out.print(ArrayOfWords[j]);
		}
	
	}

	}
	
}
