package ua.com.scread.kickstarter.main;

import java.util.Random;

import ua.com.scread.kickstarter.data.AdditionalInfo;
import ua.com.scread.kickstarter.data.Bonus;
import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.FAQ;
import ua.com.scread.kickstarter.data.Project;
import ua.com.scread.kickstarter.data.Quote;
import ua.com.scread.kickstarter.io.ConsoleIO;
import ua.com.scread.kickstarter.model.Model;
import ua.com.scread.kickstarter.storage.Bonuses;
import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.CategoriesDAO;
import ua.com.scread.kickstarter.storage.FAQs;
import ua.com.scread.kickstarter.storage.InMemoryCategories;
import ua.com.scread.kickstarter.storage.InMemoryProjects;
import ua.com.scread.kickstarter.storage.Projects;

public class Kickstarter {
	
	public static void main(String[] args) {
	    Model model = demoData();
	    
		KickstarterRunner kickstarter = new KickstarterRunner(model, new ConsoleIO(), 
		                                new Quote(new Random()));
		
		kickstarter.run();
	}
	
	public static Model demoData() {
	    Categories categories = new InMemoryCategories();
	    Projects projects = new InMemoryProjects();
	    
        Category category1 = new Category("Sport");
        Category category2 = new Category("Science");
        Category category3 = new Category("Virtual reality");
        
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Bonuses bonuses1 = new Bonuses(new Bonus(10, "Super bonus"));
        AdditionalInfo additionalInfo1 = new AdditionalInfo("History of project", "Video", 
                bonuses1, new FAQs(new FAQ("Question?", "Answer")));
        
        Bonuses bonuses2 = new Bonuses(new Bonus(10, "Oculus bonus"));
        bonuses2.add(new Bonus(100500, "You are our GOD!"));
        
        AdditionalInfo additionalInfo2 = new AdditionalInfo("History of project", 
                "https://www.youtube.com/watch?v=y4_I1DG_x7w", bonuses2, new FAQs(
                        new FAQ("Can I ship my Oculus Rift Development Kit 2 using a "
                        + "company/concierge service?","We do not allow the use of freight "
                        + "forwarding companies or concierge services \nfor Oculus Rift Development "
                        + "Kit purchases due to payment processing and fraud prevention." 
                        + "\nWe also require the information of each customer to identify the "
                        + "owner to provide \ntechnical support and product replacement.")));
        
        Project project1 = new Project("Name", "Description", 1000, 10, additionalInfo1);
        Project project2 = new Project("Oculus rift", "Virtual reality glasses", 1000, 10, additionalInfo2);
        
        project1.setCategory(category3);
        project2.setCategory(category3);

        projects.add(project1);
        projects.add(project2);
        
        return new Model(categories, projects);
    }
}
