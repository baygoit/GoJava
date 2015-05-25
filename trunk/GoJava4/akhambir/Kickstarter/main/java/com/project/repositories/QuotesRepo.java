package com.project.repositories;

import java.util.Arrays;
import java.util.List;

public class QuotesRepo implements Repo {
  private List quotesList = Arrays.asList(
          "Купи слона!",
          "Очень мотивирующая фраза",
          "Очень мотивирующая фраза2",
          "Очень мотивирующая фраза3",
          "Очень мотивирующая фраза"
  );
  public String getQuote(int index) {
    return (String) quotesList.get(index);
  }

  @Override
  public List findAll() {
    return null;
  }
}
