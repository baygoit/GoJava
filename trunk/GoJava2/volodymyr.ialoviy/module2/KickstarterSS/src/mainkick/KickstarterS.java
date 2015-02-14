package mainkick;


public class KickstarterS {
	private int chosenCategoryId;//TODO DELETE
	private int chosenProject;//TODO DELETE
	private int magic = 777;
	private int menuCategories = 222;
	private int menuProjects = 333;
	private int menuProject = 444;
	private int menuPayment = 555;
	private int menuQuestion = 666;
	private int menu = menuCategories;
	private int choiceTo;//TODO DELETE
	private int chosenPay;//TODO DELETE
	private int exit = 999;

	private InputChecker check;
	private Output out;
	private Categories categories;
	private Projects projects;

	public KickstarterS(InputChecker check, Output out, Categories categories, Projects projects) {
		this.check = check;
		this.setOut(out);
		this.categories = categories;
		this.projects = projects;
	}

	public OutputConsole getOut() {
		return (OutputConsole) out;
	}

	public void setOut(Output out2) {
		this.out = out2;
	}

	public void kickstarter() {
		Quotes quote = new Quotes();
		printer(quote.getQuote());
		
		categories.writeAllCatecories();
		projects.writeAllProjects();

		categories();
	}

	private void categories() {
		showAllCategories();
		askCategory();

		if (sleepIfMagic(chosenCategoryId)) {
			switchMenu();
		}

		menu = menuProjects;
		switchMenu();
	}

	private void projects() {
		int[] intSwitch = { menuCategories };

		printProjectsInCategory();
		askProject(intSwitch);

		if (sleepIfMagic(chosenProject)) {
			switchMenu();
		}

		if (addArrayElement(intSwitch, chosenProject)) {
			menu = menuCategories;
			switchMenu();
		}

		menu = menuProject;
		switchMenu();
	}

	private void project() {
		int[] intSwitch = { menuProjects, menuPayment, menuQuestion, exit };

		printProject();
		askAfterProject(intSwitch);

		if (sleepIfMagic(choiceTo)) {
			switchMenu();
		}

		if (addArrayElement(intSwitch, choiceTo)) {
			menu = choiceTo;
			switchMenu();
		}
	}

	private void payment() {
		int[] intSwitch = { 0, 1, 2, 3 };

		printChoicePayment();
		askHowMuchPay(intSwitch);

		if (sleepIfMagic(chosenPay)) {
			switchMenu();
		}

		printer("Enter your name:");
		String name = check.checkName();
		if (name.equals(Integer.toString(magic))) {
			sleepIfMagic(Integer.parseInt(name));
			switchMenu();
		}
		printer("Enter your credit card number:");
		long cardNumber = check.checkCard();
		if ((int) cardNumber == magic) {
			sleepIfMagic((int) cardNumber);
			switchMenu();
		}
		printer("Enter the amount of donations:");
		if (chosenPay == 0) {
			chosenPay = check.checkAmount();
			if (sleepIfMagic(chosenPay)) {
				switchMenu();
			}
		}

		projects.setDonation(chosenProject - 1, chosenPay);

		menu = menuProject;
		switchMenu();
	}

	private void question() {
		printAskQuestion();
		askQuestion();

		menu = menuProject;
		switchMenu();
	}

	private void switchMenu() {
		switch (menu) {
		case 222:
			categories();
			break;
		case 333:
			projects();
			break;
		case 444:
			project();
			break;
		case 555:
			payment();
			break;
		case 666:
			question();
			break;
		case 999:
			System.exit(0);
			break;
		}
	}

	private void showAllCategories() {
		printer(categories.getStringAllCatecories());
		printer("Choice Category Number: ");
	}

	private void askCategory() {
		chosenCategoryId = check.checkNumber(categories.getKickCategories()) - 1;
	}

	private void askProject(int[] allowedVariants) {
		chosenProject = check.checkNumber(concatArray(
				categories.projectsContain(chosenCategoryId),
				allowedVariants)); // TODO
	}

	private void askAfterProject(int[] intSwitch) {
		choiceTo = check.checkNumber(intSwitch);
	}

	private void askHowMuchPay(int[] intSwitch) {
		chosenPay = check.checkNumber(intSwitch);
	}
	
	private void askQuestion() {
		projects.addFAQ(chosenProject - 1);
	}
	
	private void printProjectsInCategory() {
		printer("Your chosen category: "
				+ categories.showCatecoryName(chosenCategoryId)
				+ ", containing the following projects: ");
		printer(categories.showAllProjectInCategory(chosenCategoryId, projects));
		printer("Choice Project Number or " + menuCategories
				+ " for exit to Category: ");
	}
	
	private void printProject() {
		printer(projects.showProjectFull(chosenProject - 1));
		printer("Choice "
				+ menuProjects
				+ " for exit to Project list.\nChoice "
				+ menuPayment
				+ " to invest in the project:"
				+ "Have a question? If the info above doesn't help, you can ask the project creator directly - Choice "
				+ menuQuestion + ":");
	}

	private void printChoicePayment() {
		printer("\"0\" - No thanks, I just want to help the project."
				+ " \"1\" - 1$ = OUR UNDYING LOVE"
				+ " \"2\" - 10$ = HEY… NICE SHIRT"
				+ " \"3\" - 40$ = KICKSTARTER EXCLUSIVE");
	}

	private void printAskQuestion() {
		printer("Enter your question:");
	}

	private Boolean sleepIfMagic(int m) {
		Boolean b = false;
		if (m == magic) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b = true;
		}
		return b;
	}

	private void printer(String string) {
		out.print(string);
	}

	private Boolean addArrayElement(int[] a, int b) {
		Boolean c = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				c = true;
				break;
			}
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