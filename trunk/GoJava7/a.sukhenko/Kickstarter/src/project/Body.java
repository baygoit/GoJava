package project;

public class Body {
	private Lang language = Lang.English;
	
	private static Body instance;

	private Body() {
	}

	public static Body getInstance() {
		if (null == instance) {
			instance = new Body();
		}
		return instance;
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
		Project first = Kickstarter.getInstance().getProjectById(0);
		ConsolePrinter.println("Project: " + first.getProjectName() + "   |  Category: " + first.getProjectCategory().toString());
		ConsolePrinter.println(first.getProjectDescription());
		ConsolePrinter.println("Backers: " + first.getBackers().size() + " | Pledged: $" + first.getMoneyPledged());
		ConsolePrinter.printDeflector();
	}

	public void generateAll() {
		generateHeader();
		generateBody();
		generateFooter();		
	}
	
}
