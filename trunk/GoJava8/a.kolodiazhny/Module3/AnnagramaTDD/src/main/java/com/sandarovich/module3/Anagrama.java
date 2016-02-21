package com.sandarovich.module3;

/**
 * @author Olexander Kolodiazhny
 */

public class Anagrama {

    private String deltimer;

    public void setDeltimer(String deltimer) {
        this.deltimer = deltimer;
    }

    public String get(String inputText) {

        String[] words = inputText.split(deltimer);
        return (words.length == 1) ?
                reverseOneWord(inputText) : reverseSentence(words);
    }

    private String reverseOneWord(String inputText) {
        return (inputText.length() == 0 || inputText.length() == 1) ?
                inputText : reverseWord(inputText);
    }

    private String reverseSentence(String[] words) {
        String[] resultArray = new String[words.length];
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            resultArray[wordIndex] = reverseWord(words[wordIndex]);
        }
        return String.join(deltimer, resultArray);
    }

    private String reverseWord(String inputText) {
        String result = "";
        char[] word = inputText.toCharArray();
        for (int charIndex = word.length - 1; charIndex >= 0; charIndex--) {
            result += word[charIndex];
        }
        return result;
    }

}
