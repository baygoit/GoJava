/**
 * Created by kossovec on 11.03.15.
 */
public class Exe002 {
  public static final String SENTENCE = "go It JAVA_3";

  public static void main(String[] args) {
    System.out.print(inverseWorlds(SENTENCE));
  }

  public static String inverseWorlds(String sentence) {
    String sentences[] = sentence.split("\\s+");
    StringBuilder sentenceSb = new StringBuilder();
    for (String sen : sentences) {
      sentenceSb.append(new StringBuffer(sen).reverse() + " ");
    }

    return sentenceSb.toString();
  }
}
