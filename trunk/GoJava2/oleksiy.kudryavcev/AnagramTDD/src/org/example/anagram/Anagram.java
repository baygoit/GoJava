package org.example.anagram;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(reverseString(scan.nextLine()));
        scan.close();
    }

    public static String reverseString(String string) {
        String[] words = string.split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder("");
            word.append(words[i]).reverse();
            if (i == (words.length - 1)) {
                result.append(word);
            } else {
                result.append(word).append(" ");
            }
        }
        return result.toString();
    }
}
