public class Engine {
	private DataStorage dataStorage;
	public Engine() {
		this.dataStorage = new DataStorage();
	}
	
	public void run() {
		Quote quote = new Quote();
		System.out.println(" Welcome to Kickstarter" + "\n"
							+ "  *** *** *** *** *** " + "\n" + quote.getRundomQuote()
							+ "\n" + "  *** *** *** *** *** ");
		int i = 1;
		for (Сategory сategory : dataStorage.getCategoriesList()) {
			System.out.println(i + ". " + сategory.getName());
			i++;
		}
		System.out.print("\n" + "Please select category: ");
		choise(new InPut().scan());
	}
	
	public void choise(int i) {
		System.out.print("Your choise: " + i + ". "
						+ dataStorage.getCategoriesList().get(i - 1).getName());
	}
}