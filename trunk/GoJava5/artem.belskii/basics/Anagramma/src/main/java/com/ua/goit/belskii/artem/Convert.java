package com.ua.goit.belskii.artem;

public class Convert {

	public String convert(String originalText) {
		StringBuilder answer = new StringBuilder();
		String DELIMETER=" ";
		String[] separateWords = originalText.split(DELIMETER);
		for (int i = 0; i < separateWords.length; i++) {
			for (int i1 = separateWords[i].length(); i1 > 0; i1--) {
				answer.append(separateWords[i].substring(i1 - 1, i1));
			}
			if (i<=separateWords.length-2){
				answer.append(" ");
			}
		}
		return answer.toString();
	}

}
