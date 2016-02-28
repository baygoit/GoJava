package com.anmertrix.module1.annagama;

public class Annagama {
	
	private IO io;
	
	public Annagama(IO io) {
		this.io = io;
	}

	public void run() {
		String[] wordsList = io.readConsole().split(" ");
		reverseWords(wordsList);
		printWords(wordsList);
	}
	
	private void reverseWords(String[] words) {
		for (int i = 0; i < words.length; i++){
			words[i] = new StringBuffer(words[i]).reverse().toString();
		}
	}
	
	private void printWords(String[] words) {
		StringBuilder line = new StringBuilder();
		
		for (String word : words) {
			line.append(word).append(" ");
		}
		
		io.print(line.toString().trim());
	}
}
