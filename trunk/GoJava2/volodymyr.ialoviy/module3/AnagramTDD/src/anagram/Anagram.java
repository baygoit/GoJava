package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
		anagram(string);
	}

	public static String anagram(String message) {
		String[] s = message.split(" ");
		String rezult = "";

		for(String ss : s){
			rezult += new StringBuilder(ss).reverse().toString() + " ";
		}
		return rezult.substring(0, rezult.length() - 1);
	}
}

