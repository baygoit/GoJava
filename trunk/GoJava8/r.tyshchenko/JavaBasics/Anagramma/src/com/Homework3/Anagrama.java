package com.Homework3;

/**
 * Created by roman on 03.03.16.
 */
public class Anagrama {
    public static String getAnagramArray(String a) {
        String[] seperateArray = a.split(" ");
        for (int i = 0; i < seperateArray.length; i++) {
            char[] wordArray = getAnagramWordArray(seperateArray[i]);
            String d = new String(wordArray);
            System.out.print(d + " ");
        }
        return a;
    }

   public static char[] getAnagramWordArray(String s) {
        char[] wordArray = s.toCharArray();
        for (int j = 0; j < wordArray.length / 2; j++) {
            char temp = wordArray[j];
            wordArray[j] = wordArray[wordArray.length - j - 1];
            wordArray[wordArray.length - j - 1] = temp;
        }
        return wordArray;
    }
}
