import java.util.List;

public class Engine {

	private CategoryStorage categoryStorage;
	private Сategory category;

	public void run(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
		Quote quote = new Quote();
		System.out.println(" Welcome to Kickstarter" + "\n"
				+ "  *** *** *** *** *** " + "\n" + quote.printQuote() + "\n"
				+ "  *** *** *** *** *** ");

		List<Сategory> a = categoryStorage.getCategoriesList();
		int i = 1;
		for (Сategory c : a) {
			System.out.println(i + ". " + c.getName());
			i++;
		}
		System.out.println("\n" + "Please select category :");

		choise(new InPut().scan());
	}

	public void choise(int i) {
		System.out.println("Your choise : " + i);
		// TO DO
	}
}