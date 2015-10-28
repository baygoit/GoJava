package com.project.view;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Quotes implements Viewer {
  private String quoteGenerating() {
    Random random = new Random();
    List quotesList;
    String randomQuote;
    quotesList = Arrays.asList(
      "Купи слона!",
      "Очень мотивирующая фраза",
      "Очень мотивирующая фраза2",
      "Очень мотивирующая фраза3",
      "Очень мотивирующая фраза"
    );
    return randomQuote = (String) quotesList.get(random.nextInt(quotesList.size()));
  }
  @Override
  public void display() {
    System.out.println(quoteGenerating());
  }
}
