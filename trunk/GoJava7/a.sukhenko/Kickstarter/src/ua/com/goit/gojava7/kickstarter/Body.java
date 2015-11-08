package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class Body {
	private Lang language = Lang.English;
	Kickstarter kickstarter;
	
	public Body(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}

	public void generateHeader(){
		if(language == Lang.Russian)
		ConsolePrinter.println(LanguageConst.RU_HELLO_MSG);
		else{
			ConsolePrinter.println(LanguageConst.ENG_HELLO_MSG);
		}
	}
	
	public void generateFooter(){
		ConsolePrinter.println("GoIT Kickstarter (c) by Artur Sukhenko");
	}
	public void generateBody(){
		ConsolePrinter.printDeflector();
		Project first = kickstarter.getProjectById(0);
		ConsolePrinter.println("Project: " + first.getProjectName() + "   |  Category: " + first.getProjectCategory().toString());
		ConsolePrinter.println(first.getProjectDescription());
		ConsolePrinter.println("Backers: " + first.getBackers().size() + " | Pledged: $" + first.getMoneyPledged());
		ConsolePrinter.printDeflector();
	}
	
	public void generateQuoteBlock(){
		Quote quote = kickstarter.getQuoteStorage().getRandomQuote();
		ConsolePrinter.printDeflector();
		ConsolePrinter.println(quote);
	}

	public void generateMainPage() {
		generateHeader();
		generateQuoteBlock();
		generateBody();
		generateFooter();		
	}
	
}
