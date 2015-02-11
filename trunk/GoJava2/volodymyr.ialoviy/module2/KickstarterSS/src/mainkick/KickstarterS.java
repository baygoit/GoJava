package mainkick;
import java.io.IOException;
import java.util.ArrayList;

public class KickstarterS {
	private int chosenCategory;
	private int chosenProject;
	private int magic = 777;
	private int menuCategories = 222;
	private int menuProjects = 333;
	private int menuProject = 444;
	private int menuPayment = 555;
	private int menuQuestion = 666;
	private int menu = menuCategories;
	Check check = new Check(new InputsConsole(), new OutputConsole());
	Categories categories = new Categories();
	Category category = new Category();
	Projects projects = new Projects();
	Project project = new Project();
	
	public void kickstarter() throws IOException, InterruptedException{
		Quotes quote = new Quotes();
		printer(quote.getQuote());
		projects.writeAllProjects();
		switcher();
	}
		
	private void categories() throws InterruptedException, IOException{
		printer(categories.readAllCatecories());
		printer("Choice Category Number: ");
		chosenCategory = check.checkNumber(category.kickContainCategory(categories));
		if (sleep(chosenCategory)){switcher();}
		printer("Your chosen category: " + category.showCatecoryName(chosenCategory - 1, categories) + ", containing the following projects: ");
		menu = menuProjects;
		switcher();
	}

	private void projects() throws IOException, InterruptedException{
		int[] intSwitch = {menuCategories};
		printer(category.showAllProjectInCategory(chosenCategory - 1, project, projects, categories));
		printer("Choice Project Number or " + menuCategories + " for exit to Category: ");
		chosenProject = check.checkNumber(concatArray(category.projectsContain(chosenCategory - 1, categories), intSwitch));
		if (sleep(chosenProject)){switcher();}
		if (compare(intSwitch, chosenProject)) {menu = menuCategories; switcher();}
		menu = menuProject;
		switcher();
	}

	private void project() throws IOException, InterruptedException{
		int[] intSwitch = {menuProjects, menuPayment, menuQuestion};
		printer(project.showProjectFull(chosenProject - 1, projects.getListProject()));
		if (project.getFaq().size() != 0){printFaq(project.getFaq());}
		printer("Choice " + menuProjects + " for exit to Project list.\nChoice " + menuPayment + " to invest in the project:");
		printer("Have a question? If the info above doesn't help, you can ask the project creator directly - Choice " + menuQuestion + ":");
		int choiceTo = check.checkNumber(intSwitch);
		if (sleep(choiceTo)){switcher();}
		if (compare(intSwitch, choiceTo)) {menu = choiceTo; switcher();}
	}
			
	private void payment() throws IOException, InterruptedException{
		int[] intSwitch = {0, 1, 2, 3};
		printer("0 - No thanks, I just want to help the project."
				+ "1 - 1$ = OUR UNDYING LOVE"
				+ "2 - 10$ = HEY… NICE SHIRT"
				+ "3 - 40$ = KICKSTARTER EXCLUSIVE");
		int chosenPay = check.checkNumber(intSwitch);
		if (sleep(chosenPay)){switcher();}
		printer("Enter your name:");
		String name = check.checkName();
		if (name.equals(Integer.toString(magic))){sleep(Integer.parseInt(name));switcher();}
		printer("Enter your credit card number:");
		long cardNumber = check.checkCard();
		if ((int)cardNumber == magic){sleep((int)cardNumber);switcher();}
		printer("Enter the amount of donations:");
		if (chosenPay == 0){
			chosenPay = check.checkAmount();
			if (sleep(chosenPay)){switcher();}
		}
		project.setDonation(projects.getListProject(), chosenPay, chosenProject - 1);
		menu = menuProject;
		switcher();
	}
	
	private void question() throws IOException, InterruptedException{
		printer("Enter your question:");
		project.setFAQ();
		menu = menuProject;
		switcher();
	}

	private void switcher() throws InterruptedException, IOException{
		switch(menu){
			case 222: categories(); break;
			case 333: projects(); break;
			case 444: project(); break;
			case 555: payment(); break;
			case 666: question(); break;
		}
	}
	
	private Boolean sleep(int m) throws InterruptedException, IOException{
		Boolean b = false;
		if (m == magic){
			Thread.sleep(10000);
			b = true;
		}
		return b;
	}
	
	private void printer(String string){
		Output out = new OutputConsole();
		out.print(string);
	}
	
	private void printFaq(ArrayList<String> faq) {
        for(int i = 0; i < faq.size(); i++){
        	printer("question " + i + " - " + faq.get(i));
        }
	}
	
	private Boolean compare(int[] a, int b) {
		Boolean c = false;
		for (int i = 0 ; i < a.length; i++){
			if (a[i] == b){
				c = true;
				break;}
		}
		return c;
	}
	
	private int[] concatArray(int[] a, int[] b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		int[] r = new int[a.length + b.length];
		System.arraycopy(a, 0, r, 0, a.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}
}