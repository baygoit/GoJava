package myRealization;

import java.util.ArrayList;
import java.util.List;

public class Kickstart {
	private List<Category> categories = new ArrayList<>();
	private int i = 1;
	
	public void buildList(Category category1, Category category2, Category category3){
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);	
	}
	
	public void showList(){
		for (Category category : categories){
			if (i == categories.size()){
				System.out.println(i + " - " + category.getName());
			} else {
				System.out.print(i + " - " + category.getName() + ", ");
				i++;	
			}
		}
		System.out.println("What are you interested in? Pleace, make your choice:");
	}
	
	public void showChoice(int index){
		System.out.println("You chose - " + categories.get(index - 1).getName());
	}
	
	public static void main(String[] args) {
		ConsoleOutput print = new ConsoleOutput();
		ConsoleScanner scan = new ConsoleScanner();
		Kickstart kick = new Kickstart();
		
		print.printQuote();
		kick.buildList(new Sport(), new Science(), new Music());
		kick.showList();
		kick.showChoice(scan.readChoice());
		
	}
}
