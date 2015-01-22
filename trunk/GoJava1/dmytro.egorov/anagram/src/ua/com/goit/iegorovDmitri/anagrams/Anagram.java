package ua.com.goit.iegorovDmitri.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Anagram {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = reader.readLine();
		String outputString = "";
		
		String[] words = (inputString.replaceAll("[^a-zA-Z0-9à-ÿÀ-ß']", " ")).replaceAll(" +"," ").split("[^a-zA-Z0-9à-ÿÀ-ß']");
		String punctuation = inputString.replaceAll("\\s", "\u0001");
		punctuation = (punctuation.replaceAll("[a-zA-Z0-9à-ÿÀ-ß]| ", " ")).replaceAll(" +"," ");
		String[] specChar = punctuation.split(" ");
		
		
		for (int i=0; i < words.length; i++){
			StringBuilder builder = new StringBuilder(words[i]);
			if(i+1<specChar.length){
			outputString+=builder.reverse().toString() + specChar[i+1];}
			else{
				outputString+=builder.reverse().toString();
			}
		}
		
		System.out.println(outputString.replaceAll("\u0001", " "));
		
	}
		
}
