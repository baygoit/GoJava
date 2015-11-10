package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Lang;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class Body {
	private Lang language = Lang.English;
	private Kickstarter kickstarter;
	private ConsolePrinter consolePrinter;
	public Body(Kickstarter kickstarter,ConsolePrinter consolePrinter2) {
		this.kickstarter = kickstarter;
		this.consolePrinter = consolePrinter2;
	}

	public void generateHeader(){
		if(language == Lang.Russian)
			consolePrinter.println(LanguageConst.RU_HELLO_MSG);
		else{
			consolePrinter.println(LanguageConst.ENG_HELLO_MSG);
		}
	}
	
	public void generateFooter(){
		consolePrinter.println("GoIT Kickstarter (c) by Artur Sukhenko");
	}
	public void generateBody(){
		Project first = kickstarter.getProjectById(0);
		generateProjectInfo(first);
	}
	
	public void generateQuoteBlock(){
		Quote quote = kickstarter.getQuoteStorage().getRandomQuote();
		consolePrinter.printDeflector();
		consolePrinter.println(quote);
	}
	public void generateCategories(){
		consolePrinter.printDeflector();
		consolePrinter.println("Categories: ");
		kickstarter.getCategoryStorage().getCategories().forEach((a,b) -> {
			generateCategoryInfo(b);
		});
	}
	public void generateMainPage() {
		generateHeader();
		generateQuoteBlock();
		generateBody();
		generateFooter();		
	}
	
	public void generateCategoryInfo(Category category){
		consolePrinter.printCategory(category);
	}
	
	public void generateProjectInfo(Project project){
		consolePrinter.printDeflector();
		consolePrinter.println("Project: " + project.getProjectName() + "   |  Category: " + project.getProjectCategory().getCategoryName());
		consolePrinter.println("[ " + project.getProjectDescription() + " ]");
		consolePrinter.println("Backers: " + project.getBackers().size() + " | Pledged: $" + project.getMoneyPledged());
	}
	
}
