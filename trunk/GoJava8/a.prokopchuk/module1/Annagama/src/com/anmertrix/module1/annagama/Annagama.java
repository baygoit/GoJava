package com.anmertrix.module1.annagama;

public class Annagama {
	
	private ConsoleIO io;
	
	public Annagama() {
		this.io = new ConsoleIO();
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
		for (int i = 0; i < words.length; i++){
			if (i != words.length - 1) {
				io.print(words[i] + " ");
			} else {
				io.print(words[i]);
			}
		}
	}
}
