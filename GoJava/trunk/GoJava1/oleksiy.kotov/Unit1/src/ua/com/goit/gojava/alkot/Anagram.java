package ua.com.goit.gojava.alkot;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите фразу:");
        String s = scan.nextLine();
        scan.close();

        String[] alphabeticStringsArray = s.split("[^a-zA-Zа-яА-Я]+");
        String[] otherStringsArray = s.split("[a-zA-Zа-яА-Я]+");

        String result = "";
        int maxIndex = Math.max(alphabeticStringsArray.length,
                otherStringsArray.length);

        if (alphabeticStringsArray[0].equals("")) // то фраза начинается с
                                                  // разделителя, а не буквы
            for (int i = 0; i < maxIndex; i++) {
                if (i < otherStringsArray.length)
                    result += otherStringsArray[i];
                if (i + 1 < alphabeticStringsArray.length)
                    result += reversOfString(alphabeticStringsArray[i + 1]);
            }
        else
            for (int i = 0; i < maxIndex; i++) {
                if (i < alphabeticStringsArray.length)
                    result += reversOfString(alphabeticStringsArray[i]);
                if (i + 1 < otherStringsArray.length)
                    result += otherStringsArray[i + 1];
            }
        System.out.println(result);

    }

    private static String reversOfString(String str) {

        String reversedStr = "";
        int strLen = str.length();

        for (int j = strLen - 1; j >= 0; j--)
            reversedStr = reversedStr + str.substring(j, j + 1);
        return reversedStr;

    }
}
