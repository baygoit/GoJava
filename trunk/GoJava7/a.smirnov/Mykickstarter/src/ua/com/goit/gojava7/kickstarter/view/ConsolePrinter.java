package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.FaqDAO;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;

public class ConsolePrinter {
	private static final TextModifer TEXT_MODIFER = new TextModifer();

	public void print(Quote quote) {
		String result = TEXT_MODIFER.getModifiedQuote(quote.getQuoteText(), quote.getAuthor());
		System.out.println(result);
	}

	public void print(Category category) {
		System.out.println("Category : " + category.getCategoryName());
	}

	public void print(String string) {
		System.out.println(string);
	}

	public void printShortProjectInfo(Project project, FaqDAO faqs, PaymentDAO payments) {
		System.out.println("Title : " + project.getTitle());
		System.out.println("Short description : " + project.getBriefDescription());
		System.out.println("Required amount : " + project.getRequiredSum());
		System.out.println("Gathered amount : " + payments.getSumProjectPayments(project));
		System.out.println("Days left : " + project.getDaysLeft());
		System.out.println("FAQ : " + faqs.getProjectFaqs(project));
	}

	public void printFullProjectInfo(Project project, FaqDAO faqStorage, PaymentDAO paymentStorage) {
		printShortProjectInfo(project, faqStorage, paymentStorage);
		System.out.println("Full description : " + project.getFullDescription());
		System.out.println("Video : " + project.getVideoLink());
	}

	public void printCategories(CategoryDAO allCategories) {
		List<Category> categories = allCategories.getAll();
		
		System.out.println("All categories : ");
		for (int index = 0; index < categories.size(); index++) {
			Category category = categories.get(index);
			System.out.println((index + 1) + " : " + category.getCategoryName());
		}
	}

	public void printProjects(List<Project> projects, FaqDAO faqStorage, PaymentDAO paymentStorage) {
		System.out.println("All projects from selected category : ");
		for (int index = 0; index < projects.size(); index++) {
			Project project = projects.get(index);				
			System.out.println("Project ¹ " + (index + 1));
			printShortProjectInfo(project, faqStorage, paymentStorage);
			System.out.println();		
		}	
	}
}
