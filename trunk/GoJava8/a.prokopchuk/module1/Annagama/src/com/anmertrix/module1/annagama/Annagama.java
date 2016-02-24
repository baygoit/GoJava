package com.anmertrix.module1.annagama;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Annagama {

	public static void main(String[] args) throws IOException {
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		reader.close();
		String[] wordsList = line.split(" ");
		printReverseWords(wordsList);
	}
	
	private static void printReverseWords(String[] words){
		for(int i=0;i < words.length;i++){
			words[i] = new StringBuffer(words[i]).reverse().toString();
			if(i != words.length - 1){
				System.out.print(words[i] + " ");
			}else{
				System.out.print(words[i]);
			}
		}
	}
}
