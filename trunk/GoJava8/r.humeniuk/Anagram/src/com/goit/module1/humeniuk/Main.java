package com.goit.module1.humeniuk;

public class Main {
	
	static String inputText = "123 321";

	public static void main(String[] args) {
		try {
			System.out.println(new AnagramBuilder().buildAnagram(inputText));
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}

}
