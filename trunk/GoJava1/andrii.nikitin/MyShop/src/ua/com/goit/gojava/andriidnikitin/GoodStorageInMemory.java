package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class GoodStorageInMemory implements GoodStorage {
	
	private List<Good> good;
	
	private List<Category> categories;
	
	public List<Good> getGoodList(Category category) {
		List<Good> listOfGoods = new ArrayList<Good>();
		for (Good tempGood : good){
			if (tempGood.getCategory() == category)
				listOfGoods.add(tempGood);
		}
		return listOfGoods;
	}
	
	public List<Category> getCategoryList() {
		return categories;
	}

	PrintStream outStream;
	
	public GoodStorageInMemory (PrintStream outStreamArg ) {//TODO: set as private
		super();
		outStream = outStreamArg;
		//initCategories();
		initGoods();
	}	

	public Good getGood(int index) {
		return good.get(index);
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}
		
	private void initGoods(){
		good = new ArrayList<Good>();
		good.add(new Good(categories.get(0), "Fender Strat"));
		good.add(new Good(categories.get(0), "Fender Tele"));
		good.add(new Good(categories.get(0), "Gibson SG"));
		good.add(new Good(categories.get(1), "Fender Rhodes"));
		good.add(new Good(categories.get(1), "Korg MS-20"));
		good.add(new Good(categories.get(2), "VOX Overdrive"));
	}
	
	/*private void initCategories(){
		categories = new ArrayList<String>();
		categories.add("Guitars");
		categories.add("Synths");
		categories.add("Other");
		
	}*/
	
	public void showGoodsInCategory(int categoryID){
		int numberInListOfGoodsInSpecifiedCategory = 0;
		categoryID--;
		for (Good good : good){
			if (good.getCategory() == getCategory(categoryID))
				outStream.println(++numberInListOfGoodsInSpecifiedCategory +
						" - " + good);
		}
		outStream.println();
	}	
	
}
