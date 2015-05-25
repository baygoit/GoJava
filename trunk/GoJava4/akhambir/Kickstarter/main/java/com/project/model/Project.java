package com.project.model;

public class Project {
  private Category category;
  private int id;
  private String name;

  public Project(Category category, Integer id, String name) {
    this.category = category;
    this.id = id;
    this.name = name;
  }

}
