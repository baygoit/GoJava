
public class Exe002 {
  public static void main(String[] args) {
    String sentence = "go It JAVA_3";
    Exe002 exe002 = new Exe002();
    exe002.inverseWorlds(sentence);
  }

  public void inverseWorlds(String sentence) {
    int start = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == ' ') {
        inverse(start, i - 1, sentence);
        start = i + 1;
        System.out.print(" ");
      } else if (i == sentence.length() - 1) {
        inverse(start, i, sentence);
      }
    }
  }

  private static void inverse(int start, int end, String sentence) {
    for (int i = end; i >= start; i--) {
      System.out.print(sentence.charAt(i));
    }
  }
}
