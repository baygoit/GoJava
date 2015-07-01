package com.ua.goit.belskii.artem;

public class Convert {

	public String convert(String originalText) {
		String answer = "";
		String[] separateWords = originalText.split(" ");
		for (int i = 0; i < separateWords.length; i++) {
			for (int i1 = separateWords[i].length(); i1 > 0; i1--) {
				answer = answer + separateWords[i].substring(i1 - 1, i1);
			}
			if (i<=separateWords.length-2){
				answer = answer + " ";
			}
		}
		return answer;
	}

}
