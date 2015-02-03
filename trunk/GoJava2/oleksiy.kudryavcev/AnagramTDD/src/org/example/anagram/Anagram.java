package org.example.anagram;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Anagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(reverseString(scan.nextLine()));
        scan.close();
    }

    public static String reverseString(String sentence) {
        return StringUtils.reverseDelimited(StringUtils.reverse(sentence), ' ');
    }
}
