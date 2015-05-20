package ua.goit.alg.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
  public String makeAnagram(String ... string) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String sentence;

    if (string.length == 0) {
      sentence = reader.readLine();
      sentence = buildAnagram(sentence);
    } else {
      sentence = buildAnagram(string[string.length - 1]);
    }
    return sentence;
  }

  private String buildAnagram(String sentence) {
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder stringBuilderBuffer = new StringBuilder();
    String[] parts = sentence.split(" ");

    for (String part : parts) {
      stringBuilder.append(stringBuilderBuffer.append(part).reverse());
      stringBuilderBuffer.delete(0, part.length());
      if (!(parts[parts.length - 1].equals(part))) {
        stringBuilder.append(" ");
      }
    }

    sentence = stringBuilder.toString();
    return sentence;
  }
}
