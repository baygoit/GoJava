package anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the words");
		String str = reader.readLine();
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse().toString());
	}
	
	
}
