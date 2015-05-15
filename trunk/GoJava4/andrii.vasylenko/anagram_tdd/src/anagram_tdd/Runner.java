package anagram_tdd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import anagram_tdd.reverse.WordsReverser;

public class Runner {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("Input words (or 'exit'):");
				String inputLine = reader.readLine();
				if ("exit".equalsIgnoreCase(inputLine)) {
					break;
				}

				System.out.println(new Anagram(inputLine, new WordsReverser()).getAnagram());
			} catch (Exception e) {
				System.out.println("Try again, please!");
			}
		}

		System.out.println("Good luck!");
	}

}
