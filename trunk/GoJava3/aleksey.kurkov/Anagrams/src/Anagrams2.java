import java.util.Scanner;

public class Anagrams2 {
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
    StringBuffer stringBuffer = new StringBuffer(s.subSequence(0, s.length()));
    return stringBuffer.reverse().toString();
  }
}