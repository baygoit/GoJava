package com.anitsai.anatolii.Anagram;

public class Anagram {

	public String[] doArrayOfAnagrams(String consoleString) {
		String[] arrayStr = consoleString.trim().split("\\s+");
		String[] anagrams = new String[arrayStr.length];
		for (int i = 0; i < arrayStr.length; i++) {
			String anagram = this.doAnagram(arrayStr[i]);
			anagrams[i] = anagram;
		}
		return anagrams;
	}

	public String doAnagram(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length / 2; i++) {
			char newChar = charArray[i];
			charArray[i] = charArray[charArray.length - i - 1];
			charArray[charArray.length - i - 1] = newChar;
		}
		String str1 = new String(charArray);
		return str1;
	}

	public String getAnagrams(String str) {
		String[] arrayAnagrams = doArrayOfAnagrams(str);
		String stringOfAnagrams = arrayAnagrams[0];
		for (int i = 1; i < arrayAnagrams.length; i++) {
			stringOfAnagrams = stringOfAnagrams + " " + arrayAnagrams[i];
		}
		return stringOfAnagrams;
	}

}
