package ua.com.goit.gojava2.solo307.makeanagram; 

import java.util.Scanner;

public class AnagramMaker {
	
	public String scanStr(){
		System.out.println("Please, enter the string");
		return new String(new Scanner(System.in).nextLine());
	}
	
	public String [] separateWordsBySymbols(String inLine){
		String [] words = inLine.split("\\W+");
		return words;
	}
	
	public String [] collectSymbolsToArray(String inLine){
		String [] symbols = inLine.split("\\w");
		return symbols;
	}
	
	public String revertWords(String [] words){
		String revertedWords = "";
		for(int i = 0; i < words.length; i++){
			revertedWords += new StringBuffer(words[i]).reverse().toString();
		}
		return revertedWords;
	}
	
	public String insertSymbols(String revertedWords, String [] symbols){
		StringBuffer stringBuffer = new StringBuffer(revertedWords);
		int shiftCounter = 0;
		for(int i = 0; i < symbols.length; i++){
			if(!symbols[i].equals("")){
				stringBuffer.insert(i + shiftCounter, symbols[i]);
				shiftCounter += symbols[i].length();
			}
		}
		return new String(stringBuffer.toString());
	}
	
	public static void main(String[] args) {
		AnagramMaker anagramMaker = new AnagramMaker();
		String inLine = anagramMaker.scanStr(); 
		String [] words = anagramMaker.separateWordsBySymbols(inLine);
		String [] symbols = anagramMaker.collectSymbolsToArray(inLine);
		String revertedWords = anagramMaker.revertWords(words);
		String anagram = anagramMaker.insertSymbols(revertedWords, symbols);
		System.out.println(anagram);
	}
}