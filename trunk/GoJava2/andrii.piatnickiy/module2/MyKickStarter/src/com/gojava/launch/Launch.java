package com.gojava.launch;

import java.util.ArrayList;
import java.util.Scanner;

import Quote.Quote;
import View.Menu;

import com.gojava.input.Scan;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        int categoryNumber;
        int projectNumber;
        int nubberForNextLevel;
        Scan scan = new Scan();
        Quote quote = new Quote();
        Menu menu = new Menu();
        ProjectManager manager = new ProjectManager();
        quote.displayQuote();
       
        
        menu.level1.displayMySelf(menu.currentPosition);
        menu.currentPosition++;
        nubberForNextLevel = scan.inputInt(); 
        menu.level3.parentPosition = nubberForNextLevel;
        menu.nextLevel(nubberForNextLevel, menu.levelsList);
        nubberForNextLevel = scan.inputInt(); 
        menu.nextLevel(nubberForNextLevel, menu.levelsList);
        

        // manager.displayCategories();
        // categoryNumber = scan.inputInt();
        // manager.displayProjects(categoryNumber);
        // projectNumber = scan.inputInt();
        // while (true) {
        // if (projectNumber == 0) {
        // manager.displayCategories();
        // } else {
        // manager.displaySpecificProject(categoryNumber, projectNumber);
        // }
        // categoryNumber = scan.inputInt();
        // manager.displayProjects(categoryNumber);
        // }
    }
}
