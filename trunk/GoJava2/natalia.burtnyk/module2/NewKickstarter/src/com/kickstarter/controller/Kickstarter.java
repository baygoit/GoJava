package com.kickstarter.controller;

import java.util.Random;

import com.kickstarter.model.Categories;
import com.kickstarter.model.QuotesDao;
import com.kickstarter.model. CategoriesDao;
import com.kickstarter.model.Projects;
import com.kickstarter.model.Project;
import com.kickstarter.model.InMemoryProjects;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.In;
import com.kickstarter.view.OutConsole;
import com.kickstarter.view.View;
import com.kickstarter.view.InPutConsole;

public class Kickstarter {

    public static void main(String[] args) {
    	QuotesDao quotesStorage = new QuotesDao();
    	View consoleView = new View(new OutConsole());
    	Categories categories = new  CategoriesDao();
    	Projects projects = new InMemoryProjects();
    	In inPut = new InPutConsole();
    	
    	Сategory food = new Сategory("FOOD");
    	Сategory music = new Сategory("MUSIC");
    	Сategory education = new Сategory("EDUCATION");

    	categories.add(food);
    	categories.add(music);
    	categories.add(education);
    	
    	Project project1 = new Project("Green Pea Cookie. ", "We want to produce green cookies. ",
    				"Coming soon... ","http:gps.rom.new", 8000, 3654, 17);
    	Project project2 = new Project("House wine. ", "We make delicious homemade wine. ",
    				"Coming soon... ", "http:hw.est.new",14000, 9006, 20);
    	Project project3 = new Project("CookBook. ", "We have collected recipes 2000 and we want"
				 	+ " to release a book. ","Coming soon. . ", "http:cb.gri.new",12000, 2700, 28);
    	Project project4 = new Project("Musical Instruments. ", "Help for beginners. ",
    				"Coming soon...  ","http:mi.beg.new ",25000, 12908, 48);
    	Project project5 = new Project("English Speaking Club Online. ", "Сommunication with "
    				+ "native speakers via internet. ", "Coming soon. .  ", "http:esco.com.new", 30000, 20124, 9);
    	Project project6 = new Project("Martial Arts. ", "Study of martial arts. ",
					"Coming soon...  ", "http:ma.st.new", 48000, 5798, 56);
    	
    	project1.setСategory(food);
    	project2.setСategory(food);
    	project3.setСategory(food);
    	project4.setСategory(music);
    	project5.setСategory(education);
    	project6.setСategory(education);
    	
    	projects.add(project1);
    	projects.add(project2);
    	projects.add(project3);
    	projects.add(project4);
    	projects.add(project5);
    	projects.add(project6);
    
        KickstarterEngine engine = new KickstarterEngine(consoleView, quotesStorage, inPut, categories, projects);
        engine.run();
    }
}