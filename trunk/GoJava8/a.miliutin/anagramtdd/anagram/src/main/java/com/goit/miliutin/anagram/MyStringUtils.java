package com.goit.miliutin.anagram;

import java.util.Arrays;

public class MyStringUtils {

    public static String anagram(String input) {
        char[] normal = input.toCharArray();
        char[] anagram = reverse(normal);       

        return parseToString(anagram);
    }

    private static char[] reverse(char[] normal) {
        char[] reverse = new char[normal.length];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = normal[(normal.length-1)-i];
        }
        return reverse;        
    }
    
    private static String parseToString(char[] current){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current.length; i++) {
            sb.append(current[i]);            
        }
        return sb.toString();
    }

}

