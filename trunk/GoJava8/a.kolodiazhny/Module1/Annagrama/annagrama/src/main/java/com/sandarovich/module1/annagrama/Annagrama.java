package com.sandarovich.module1.annagrama;

public class Annagrama {
    public String reversed(String message) {
        String[] words = message.split(" ");
        StringBuilder outSentence = new StringBuilder();
        
        for (String word: words) {
            outSentence.append(reverseWord(word) + " ");
        }
        String out = outSentence.toString();
        return out.trim();
        
    }
    
    private String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder = stringBuilder.reverse();
        return stringBuilder.toString();
    }
    
}
