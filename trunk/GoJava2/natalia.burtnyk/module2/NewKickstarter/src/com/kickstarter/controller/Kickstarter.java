package com.kickstarter.controller;

import com.kickstarter.model.DataStorage;
import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;
import com.kickstarter.view.ConsoleView;
import com.kickstarter.view.InPut;

public class Kickstarter {

    public static void main(String[] args) {
    	DataStorage dataStorage = new DataStorage();
    	ConsoleView consoleView = new ConsoleView();
    	InPut inPut = new InPut();
    	
    	String quote1 = "\"Lost time is never found again.\"";
    	String quote2 = "\"The future belongs to those, who believe of their dreams.\"";
    	String quote3 = "\"If you never try you'll never know.\"";
    	String quote4 = "\"The only way to do great work, is to love what you do.\"";
    	String quote5 = "\"Every thing is easy, when you are crazy and nothing is easy when you are lazy.\"";
    	String quote6 = "\"An investment in knowledge always pays the best interest.\"";
    	String quote7 = "\"It does not matter how slowly you go so long as you do not stop.\"";
    	String quote8 = "\"Money spent on the brain, is never spent in vain.\"";
    	
    	dataStorage.addQuote(quote1);
    	dataStorage.addQuote(quote2);
    	dataStorage.addQuote(quote3);
    	dataStorage.addQuote(quote4);
    	dataStorage.addQuote(quote5);
    	dataStorage.addQuote(quote6);
    	dataStorage.addQuote(quote7);
    	dataStorage.addQuote(quote8);
    	
    	Сategory food = new Сategory("FOOD");
    	Сategory music = new Сategory("MUSIC");
    	Сategory education = new Сategory("EDUCATION");

    	dataStorage.addCategory(food);
    	dataStorage.addCategory(music);
    	dataStorage.addCategory(education);
    	
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
    	
    	dataStorage.addProject(project1);
    	dataStorage.addProject(project2);
    	dataStorage.addProject(project3);
    	dataStorage.addProject(project4);
    	dataStorage.addProject(project5);
    	dataStorage.addProject(project6);
    
        KickstarterEngine engine = new KickstarterEngine(consoleView, dataStorage, inPut);
        engine.run();
    }
}