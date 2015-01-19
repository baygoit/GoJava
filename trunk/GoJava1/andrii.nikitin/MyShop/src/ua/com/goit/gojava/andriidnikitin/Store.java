package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Store {
	
	private List<Goods> goods = new ArrayList<Goods>();
	
	private List<String> categories = new ArrayList<String>();

	PrintStream outStream;
	
	public Store (PrintStream outStreamArg ){
		outStream = outStreamArg;
		initGoods();
		initCategories();
	}
	
	private void initGoods(){
		goods.add(new Goods(categories.get(0), "Fender Strat"));
	}
	
	private void initCategories(){
		categories.add("Guitars");
		categories.add("Synths");
		categories.add("Other");
		
	}
	
	public void showCategories(){
		for (int i = 0; i < categories.size(); i++) 
			System.out.println(i + 1 + " - " + categories.get(i));
	}
	
	public void showGoodsInCategory(String chosenCategory){
		int numberInListOfGoodsInSpecifiedCategory = 0;
		for (Goods good : goods){
			if (good.getCategory() == chosenCategory)
				System.out.println(numberInListOfGoodsInSpecifiedCategory++ + 
						" - " + good);
		}
	}	
}




