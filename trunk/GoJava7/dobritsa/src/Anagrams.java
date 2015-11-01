
import java.util.Scanner;


public class Anagrams{	

	public static void main(String[] args) {		
		String typedText = (typeText());			
		System.out.println("Anagram: " + anagram(typedText));
		System.out.println("");
		
		String myText = "to be or not to be";
		System.out.println("Original text: " + myText);	
		System.out.println("Anagram: " + anagram(myText));		
	}
	
	public static String anagram(String text) {
		String[] textArray = text.split(" ");
		for (int i = 0; i < textArray.length; i++) {
			textArray[i] = reverseWord(textArray[i]);		
		}		
		String anagram = "";
		for(int i = 0; i < textArray.length; i++) {
			anagram += " " + textArray[i].toString();
		}
		return anagram;		
	}
	
	public static String reverseWord(String word) {
		 if (word.length() <= 1) return word;	
		 char[] wordChar=word.toCharArray();		 
		 char reverseWordChar[] = new char[wordChar.length];		
		 for (int i = 0, y = wordChar.length - 1; i < wordChar.length; i++) {			 
			 reverseWordChar[i] = wordChar[y--];	
		 }	
		 return new String(reverseWordChar);	
	}
	
	public static String typeText() {		
		Scanner sc = new Scanner(System.in);		
		System.out.print("Type the text: ");
		String text = sc.nextLine();
		sc.close();
		if (text.isEmpty()) {
			System.out.println("You typed incorrect data");
		}		
		return text;
	}
}
