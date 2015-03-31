
public class Exe002 {
  public static final String SENTENCE = "go It JAVA_3";
  public static char[] charsFromSentence;

  public static void main(String[] args) {
    inverseWorlds(SENTENCE);
  }

  public static void inverseWorlds(String sentence) {
    charsFromSentence = SENTENCE.toCharArray();
    int start = 0;

    for (int i = 0; i < charsFromSentence.length; i++) {
      if (charsFromSentence[i] == ' ') {
        inverce(start, i - 1, charsFromSentence);
        start = i + 1;

      } else if (i == charsFromSentence.length - 1) {
        inverce(start, i, charsFromSentence);
        start = i + 1;
      }
    }
  }

  private static void inverce(int start, int end, char[] array) {
    for (int i = end; i >= start; i--) {
      System.out.print(array[i]);
    }

    System.out.print(" ");
  }
}
