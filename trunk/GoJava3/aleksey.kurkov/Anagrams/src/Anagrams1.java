import java.util.Scanner;

/**
 * Created by Aleksey Kurkov on 11.03.15.
 */

public class Anagrams1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your phrase: ");
        String phrase = scanner.nextLine();

        String[] phraseArray;
        phraseArray = phrase.split(" ");

        System.out.print("Anagram: ");

        for (int i = 0; i < phraseArray.length; i++) {
            System.out.print(reverse(phraseArray[i]));

            if (i != phraseArray.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0, j = s.length() - 1; i <= s.length() - 1; ++i, --j) {
            stringBuilder.append(s.charAt(j));
        }

        return stringBuilder.toString();
    }
}