public class Engine {
	private DataStorage dataStorage;

	public Engine() {
		this.dataStorage = new DataStorage();
	}

	public void run() {
		System.out.println(" Welcome to Kickstarter" + "\n"
				+ "  *** *** *** *** *** " + "\n"
				+ dataStorage.getRundomQuote() + "\n"
				+ "  *** *** *** *** *** ");

		int i = 1;
		for (Сategory сategory : dataStorage.getCategoriesList()) {
			System.out.println(i + ". " + сategory.getName());
			i++;
		}
		System.out.print("\n" + "Please select category: ");
		choise(new InPut().scan());
	}

	public void choise(int i) {
		Сategory сategory = dataStorage.getCategoriesList().get(i - 1);
		System.out.print("\n" + "Your choise: " + i + ". " + сategory.getName()
						+ "\n" + "---- Here are the projects ----" + "\n");

		for (Project p : dataStorage.getSpecificProject(сategory)) {
			System.out.println(p.allInformation() + "\n"
						+ "----------------------------" + "\n");
		}

	}

}