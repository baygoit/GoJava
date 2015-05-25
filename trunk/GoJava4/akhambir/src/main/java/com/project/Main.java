package com.project;

import com.project.controller.Controller;
import com.project.controller.GetAllCategoryControllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
  Map<Request, Controller> controllerMap = new HashMap<>();
  Controller controller;
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String commandLine = "";
    initializeControllersMap();
    do {
      if (commandLine.equals("")) {

      }

      commandLine = reader.readLine();

    } while (commandLine.equals("exit"));
  }

  private static void initializeControllersMap() {
    Controller getAllCategories = new GetAllCategoryControllers();
  }
}
