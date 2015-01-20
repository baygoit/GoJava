package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class GoodsStorage {
	
	private List<Goods> goods;
	
	private List<String> categories;
	
	PrintStream outStream;
	
	public GoodsStorage (PrintStream outStreamArg ) {//TODO: set as private
		super();
		outStream = outStreamArg;
		initGoods();
		initCategories();
	}	

	public Goods getGood(int index) {
		return goods.get(index);
	}

	public String getCategory(int index) {
		return categories.get(index);
	}
		
	private void initGoods(){
		goods = new ArrayList<Goods>();
		goods.add(new Goods(categories.get(0), "Fender Strat"));
		goods.add(new Goods(categories.get(0), "Fender Tele"));
		goods.add(new Goods(categories.get(0), "Gibson SG"));
		goods.add(new Goods(categories.get(1), "Fender Rhodes"));
		goods.add(new Goods(categories.get(1), "Korg MS-20"));
		goods.add(new Goods(categories.get(2), "VOX Overdrive"));
	}
	
	private void initCategories(){
		categories = new ArrayList<String>();
		categories.add("Guitars");
		categories.add("Synths");
		categories.add("Other");
		
	}
	
	public void showCategories(){
		for (int i = 0; i < categories.size(); i++) 
			System.out.println(i + 1 + " - " + categories.get(i));
	}
	
	public void showGoodsInCategory(int categoryID){
		int numberInListOfGoodsInSpecifiedCategory = 0;
		for (Goods good : goods){
			if (good.getCategory() == getCategory(categoryID))
				System.out.println(numberInListOfGoodsInSpecifiedCategory++ + 
						" - " + good);
		}
	}	
	
}
