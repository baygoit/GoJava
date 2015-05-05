package v01;
import java.util.Scanner;


public class Kickstarter {

	
	public static void main(String[] args) {
		
		System.out.println("Welcome to KICKSTARTER v0.1");
		System.out.println(Quote.getQuote());
		
		Kickstarter kickstarter = new Kickstarter();
		Category category = new Category();
		
		category.showCategoryList();
	}

	
}







