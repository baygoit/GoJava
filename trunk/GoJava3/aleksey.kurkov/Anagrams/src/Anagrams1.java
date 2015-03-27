import java.util.Scanner;

/* Test cases
*  Input: Мама мыла раму
*  Output: амаМ алым умар
*  */

public class Anagrams1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input your phrase: ");

    StringBuilder phrase = new StringBuilder();
    phrase.append(scanner.nextLine());
    scanner.close();

    System.out.print("Anagram: ");

    for (int i = 0, start = 0; i < phrase.length(); i++) {
      // looking for a space char
      if (phrase.charAt(i) == ' ') {
        System.out.print(reverse(phrase.substring(start, i)) + " ");
        start = i + 1;
      }
      // looking for the end of line
      if (i == phrase.length() - 1) {
        System.out.print(reverse(phrase.substring(start, i + 1)));
      }
    }
  }

  public static String reverse(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int j = s.length() - 1; j >= 0; j--) {
      stringBuilder.append(s.charAt(j));
    }
    return stringBuilder.toString();
  }
}