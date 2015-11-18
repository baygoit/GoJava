package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Faq;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.FaqStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.PaymentStorage;;

public class ConsolePrinter {
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final TextModifer TEXT_MODIFER = new TextModifer();

	public void print(Quote quote) {
		String result = TEXT_MODIFER.getModifiedQuoteBeforePrint(quote.getQuoteText(), quote.getAuthor());
		System.out.println(result);
	}

	public void print(Category category) {
		System.out.println("Category : " + category.getCategoryName());
	}

	public void print(String string) {
		System.out.println(string);
	}

	public void printShortProjectInfo(Project project, FaqStorage faqStorage, PaymentStorage paymentStorage) {
		System.out.println("Title : " + project.getTitle());
		System.out.println("Short description : " + project.getBriefDescription());
		System.out.println("Required amount : " + project.getRequiredSum());
		System.out.println("Gathered amount : " + paymentStorage.getPayments(project));
		System.out.println("Days left : " + project.getDaysLeft());
		printFAQs(faqStorage, project);
	}

	public void printFullProjectInfo(Project project, FaqStorage faqStorage, PaymentStorage paymentStorage) {
		printShortProjectInfo(project, faqStorage, paymentStorage);
		System.out.println("History : " + project.getFullDescription());
		System.out.println("Video : " + project.getVideoLink());
	}

	public void printCategories(List<Category> categories) {
		System.out.println("All categories : ");
		for (int index = 0; index < categories.size(); index++) {
			Category category = categories.get(index);
			System.out.println((index + 1) + " : " + category.getCategoryName());
		}
	}

	public void printProjects(List<Project> projects, FaqStorage faqStorage, PaymentStorage paymentStorage) {
		System.out.println("All projects from selected category : ");
		
		for (int index = 0; index < projects.size(); index++) {
			Project project = projects.get(index);
			System.out.println("Project ¹ " + (index + 1));
			printShortProjectInfo(project, faqStorage, paymentStorage);
			System.out.println();
		}	
	}

	public void printFAQs(FaqStorage faqStorage, Project project) {
		List<Faq> allFaqs = faqStorage.getAll();
		if (allFaqs.size() == 0) {
			System.out.println("There is no questions in this projects");
		} else {
			System.out.println("FAQ : ");
			for (int index = 0; index < allFaqs.size(); index++) {
				if (allFaqs.get(index).getProjectID() == project.getUniqueID()) {
					System.out.println("  question : " + allFaqs.get(index).getQuestion());
				}
			}
		}
	}
}
