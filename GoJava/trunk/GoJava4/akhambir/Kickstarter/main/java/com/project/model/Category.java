package com.project.model;

public class Category {
  private Project project;
  private int id;
  private String name;

  public Category(Integer id, String name) {
    this.id = id;
    this.name = name;
  }
}
