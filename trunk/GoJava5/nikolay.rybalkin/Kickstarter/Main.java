import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	private String SPACE = " ";
    
	public Main(Ñategories categories) {
		this.categories = categories;
	}

	public static void main(String[] args){
		
		Category category1 = new Category("Game");
		Category category2 = new Category("Design");
		Category category3 = new Category("Technology");
		
		Ñategories categories = new Ñategories();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
    	Main app = new Main(categories);
    	app.run();
    }

	private Ñategories categories;
	private int b;
    
    private void run() {
    	
    	QuoteGenerate generate = new QuoteGenerate();
    	System.out.println(generate.quoteGenerate());
    	System.out.println(SPACE);
    	System.out.println("Select category: ");
    	System.out.println(Arrays.toString(categories.getÑategories()));
    	
    	ScanConsole scanConsole = new ScanConsole();
    	String categoryName = categories.getName(scanConsole.consoleScan(b));
    	System.out.println("You selected category: " + categoryName);
	}
}

