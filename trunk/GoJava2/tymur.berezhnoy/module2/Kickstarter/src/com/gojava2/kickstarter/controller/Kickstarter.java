package com.gojava2.kickstarter.controller;

import java.util.Properties;

import com.gojava2.kickstarter.dao.ConnectionPooll;
import com.gojava2.kickstarter.dao.QuoteDAO;
import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.CategoryStorageInMemory;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.ProjectStorageInMemory;
import com.gojava2.kickstarter.model.QuoteStorage;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class Kickstarter {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put("jdbc.driver", "org.postgresql.Driver");
		properties.put("url", "jdbc:postgresql://localhost:5432/kickstarter");
		properties.put("user", "postgres");
		properties.put("password", "Berezhnoi");
		
		QuoteStorage quoteStorage = new QuoteDAO(new ConnectionPooll(properties));
		CategoryStorage categoryStorage = new CategoryStorageInMemory();
		ProjectStorage projectStorage = new ProjectStorageInMemory();
		Category category1 = new Category("Art");
        Category category2 = new Category("Comics");
        Category category3 = new Category("Dance");
        Category category4 = new Category("Gamse");
        
        categoryStorage.addCategory(category1);
        categoryStorage.addCategory(category2);
        categoryStorage.addCategory(category3);
        categoryStorage.addCategory(category4);
                        
        
        Project project1 = new Project("NY artists", "Some description.", 10000, 200, 25, 1,
                        "There'll be history", "http://www.nyart.com");
        Project project2 = new Project("The observatory", "Little observatory.", 2000, 100, 17, 1,
                        "There'll be history", "http://www.observatory.com");
        Project project3 = new Project("The sing for hope pianos", "The pianos who play in the streat.",
                        15000, 5000, 4, 30, "There'll be history", "http://www.pianos.com");
        Project project4 = new Project("Super Man", "Comic about a man having super powers.",
                        50000, 1000, 15, 5, "There'll be history", "http://www.superman.com");
        Project project5 = new Project("Hulk", "Comics on the green hero named Hulk.", 
                        20000, 100, 50, 2,"There'll be history", "http://www.hulk.com");
        Project project6 = new Project("Spider man", "Little - little spider man.", 4000, 200,
                        40, 1,"There'll be history", "http://www.spiderman.com");
        Project project7 = new Project("Dance & Fly", "You can dance, you can fly, we belive in you!",
                        5000, 1000, 15, 7, "There'll be history", "http://www.df.com");
        Project project8 = new Project("Tiny Epic Galaxies", "Develop your empire and "
                        + "colonize planets to create the most powerful galaxy!",
                        100000, 30000, 50, 17, "There'll be history", "http://www.galaxies.com");
        Project project9 = new Project("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG "
                        + "set in 2056's Magically Awakened Hong Kong by the developers of "
                        + "Shadowrun Returns & Dragonfall.",
                        30000, 2000, 33, 10, "There'll be history", "http://www.shadowrun.com");
        Project project10 = new Project("Starr Mazer", "A retro-sexy Point-and-Click Adventure "
                        + "Shoot 'em Up in SPACE!", 50000, 3000, 20, 6, "There'll be history", 
                        "http://www.starr mazer.com");
        
        project1.setCategory(category1);
        project2.setCategory(category1);
        project3.setCategory(category1);
        
        project4.setCategory(category2);
        project5.setCategory(category2);
        project6.setCategory(category2);
        
        project7.setCategory(category3);
        
        project8.setCategory(category4);
        project9.setCategory(category4);
        project10.setCategory(category4);
        
        projectStorage.addProject(project1);
        projectStorage.addProject(project2);
        projectStorage.addProject(project3);
        projectStorage.addProject(project4);
        projectStorage.addProject(project5);
        projectStorage.addProject(project6);
        projectStorage.addProject(project7);
        projectStorage.addProject(project8);
        projectStorage.addProject(project9);
        projectStorage.addProject(project10);
        
        KickstarterController app = new KickstarterController(quoteStorage, categoryStorage,
                                                                                                                        projectStorage, new ConsoleView(),
                                                                                                                        new ConsoleInput());
        app.run();
	}
}