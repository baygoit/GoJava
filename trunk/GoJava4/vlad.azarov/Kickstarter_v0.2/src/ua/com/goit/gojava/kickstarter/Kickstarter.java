package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Random;

public class Kickstarter {

    private Categories categories;
    
    public Kickstarter(Categories categories) {
	this.categories = categories;
    }

    public static void main(String[] args) {
	
	Category category1 = new Category("Photo");
	Category category2 = new Category("Video");
	Category category3 = new Category("Music");
	
	Categories categories = new Categories();
	
	categories.add(category1);
	categories.add(category2);
	categories.add(category3);
	
	Kickstarter application = new Kickstarter(categories);
	application.run();
    }


    private void run() {
	
	QuotesGenerator generator = new QuotesGenerator();
	System.out.println(generator.nextQuote());
	
	System.out.println();
	System.out.println("Choose the category:");
	System.out.println(Arrays.toString(categories.getCategories()));
	
    }
}
