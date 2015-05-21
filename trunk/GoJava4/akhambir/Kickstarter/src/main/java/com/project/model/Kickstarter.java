package com.project.model;

import com.project.view.Display;
import com.project.view.Quotes;
import com.project.view.Viewer;

public class Kickstarter {
  private Viewer viewer;
  private Category category;
  private User user;

  public Kickstarter() {
    this.viewer = new Quotes();
    this.viewer = new Display();
  }

  public void displayQuotes() {
    viewer.display();
  }

  public void displayD() {
    viewer.display();
  }
}
