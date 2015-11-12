package ua.com.goit.gojava7.kickstarter.console;

import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private  final String deflector = "===========================";
	public  void println(String s){
		System.out.println(s);
	}
	public  void printDeflector(){
		System.out.println(deflector);
	}
	public  void println(Quote quote) {
		System.out.println("\"" + quote.getQuoteName() + "\"\n" + quote.getAuthor());
		
	}
	public  void printCategory(Category b) {
		System.out.println(b.getCategoryId() + "# " + b.getCategoryName());
		
	}
	
	
	
	public void print(Map<Integer,Category> categories){
		System.out.println("Categories: ");
		categories.forEach((id,cat) ->{
			System.out.println(id +"# " + cat.getCategoryName());
		});
	}
}
