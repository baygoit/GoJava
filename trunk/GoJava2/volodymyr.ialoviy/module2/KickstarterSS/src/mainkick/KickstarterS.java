package mainkick;
import java.io.FileNotFoundException;
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
	private int choiceTo;
	private int chosenPay;
	private int exit = 999;
	
	private Check check;
	private Output out;
	private Categories categories;
	private Category category;
	private Projects projects;
	private Project project;
	
	public KickstarterS(Check check, Output out, Categories categories, Category category, Projects projects, Project project) {
		this.check = check;
		this.setOut(out);
	
        this.categories = categories;
        this.category = category;
        this.projects = projects;
        this.project = project;
	}
	
	public OutputConsole getOut() {
		return (OutputConsole) out;
	}

	public void setOut(Output out2) {
		this.out = out2;
	}
	
	
	
	public void kickstarter() throws IOException, InterruptedException{
		Quotes quote = new Quotes();
		printer(quote.getQuote());
		projects.writeAllProjects();
		categories.readAllCatecories();
		categories();
	}
		
	private void categories() throws InterruptedException, IOException{
		printCategories();
		askCategory();
		
		if (sleep(chosenCategory)){switcher();}
		
		menu = menuProjects;
		switcher();
	}

	private void projects() throws IOException, InterruptedException{
		int[] intSwitch = {menuCategories};
		
		printProjects();
		askProject(intSwitch);
		
		if (sleep(chosenProject)){switcher();}
		
		if (compare(intSwitch, chosenProject)) {menu = menuCategories; switcher();}
		
		menu = menuProject;
		switcher();
	}

	private void project() throws IOException, InterruptedException{
		int[] intSwitch = {menuProjects, menuPayment, menuQuestion, exit};
		
		printProject();
		askAfterProject(intSwitch);
		
		if (sleep(choiceTo)){switcher();}
		
		if (compare(intSwitch, choiceTo)) {menu = choiceTo; switcher();}
	}
	
	private void payment() throws IOException, InterruptedException{
		int[] intSwitch = {0, 1, 2, 3};
		
		printChoicePayment();
		askHowMuchPay(intSwitch);

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
		printQuestion();
		askQuestion();

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
			case 999: System.exit(0); break;
		}
	}
	
	private void printCategories() throws FileNotFoundException {
		printer(categories.showAllCatecories());
		printer("Choice Category Number: ");		
	}

	private void askCategory() throws IOException {
		chosenCategory = check.checkNumber(categories.kickContainCategory()) - 1;
	}
	
	private void printProjects() throws FileNotFoundException {
		printer("Your chosen category: " + category.showCatecoryName(chosenCategory, categories) + ", containing the following projects: ");		//TODO
		printer(category.showAllProjectInCategory(chosenCategory, projects, categories));															//TODO project поменял на projects
//		printer(category.showAllProjectInCategory(chosenCategory - 1, project, projects, categories));
		printer("Choice Project Number or " + menuCategories + " for exit to Category: ");
	}

	private void askProject(int[] intSwitch) throws IOException {
		chosenProject = check.checkNumber(concatArray(category.projectsContain(chosenCategory, categories), intSwitch));							//TODO
	}
	
	private void askAfterProject(int[] intSwitch) throws IOException {
		choiceTo = check.checkNumber(intSwitch);		
	}

	private void printProject() throws FileNotFoundException {
		printer(projects.showProjectFull(chosenProject - 1));//TODO project поменял на projects
		if (project.getFaq().size() != 0){printFaq(project.getFaq());}
		printer("Choice " + menuProjects + " for exit to Project list.\nChoice " + menuPayment + " to invest in the project:"
				+ "Have a question? If the info above doesn't help, you can ask the project creator directly - Choice " + menuQuestion + ":");
	}
	
	private void askHowMuchPay(int[] intSwitch) throws IOException {
		chosenPay = check.checkNumber(intSwitch);		
	}

	private void printChoicePayment() {
		printer("0 - No thanks, I just want to help the project."
				+ "1 - 1$ = OUR UNDYING LOVE"
				+ "2 - 10$ = HEY… NICE SHIRT"
				+ "3 - 40$ = KICKSTARTER EXCLUSIVE");		
	}
	
	private void askQuestion() throws IOException {
		project.setFAQ();		
	}

	private void printQuestion() {
		printer("Enter your question:");		
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