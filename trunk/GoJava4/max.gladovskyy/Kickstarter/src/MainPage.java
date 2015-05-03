import java.util.ArrayList;


public class MainPage {
	private static MainPage instance;
	private Quote quote;
	private ArrayList<Category> categorys = new ArrayList<Category>();
	
	private MainPage(ArrayList<Category> categorys, Quote quote) {
		this.categorys = categorys;
		this.quote = quote;
	}
	
	public void print() {
		Console.clearScreen();
		System.out.println(quote.getQuote());
		System.out.println();
		System.out.println("Choose category to explore and press enter:");
		for (Category category: categorys) {
			System.out.println(categorys.indexOf(category)+1+") "+category.getName());
		}

		int userChois = Console.getUserChois(categorys.size(),Console.NO_EXIT);
		categorys.get(userChois-1).print();
	}

	public static MainPage getMainPage() {
		if (instance == null) {
			instance = new MainPage(Data.getCategorys(), Data.getQuote());		
		}
	return instance;
	}
}
