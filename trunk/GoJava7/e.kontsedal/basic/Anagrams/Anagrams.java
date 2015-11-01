import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagrams {
	public static void main(String[] args) throws IOException {
		reverseWords(readPhrase());		
	}
	/*Reading phrase from console*/
	public static String readPhrase() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		String inputPhrase = reader.readLine();
		reader.close();
		return inputPhrase;
	}
	/*Reversing of words in phrase separated by space*/
	public static void reverseWords(String phrase) {
		String[] words = phrase.split(" ");
		for (String string : words) {
			StringBuffer sBuffer = new StringBuffer(string);
			System.out.print(sBuffer.reverse() + " ");
		}
	}
	

}
