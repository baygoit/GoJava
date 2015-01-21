package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.List;

public class GoodStorageInMemory implements GoodStorage {
	
	private List<Good> goods;
	
	private List<Category> categories;
	
	public List<Good> getGoodList(Category category) {
		List<Good> listOfGoods = new ArrayList<Good>();
		for (Good tempGood : goods){
			if (tempGood.getCategory() == category)
				listOfGoods.add(tempGood);
		}
		return listOfGoods;
	}
	
	public List<Category> getCategoryList() {
		return categories;
	}

	public GoodStorageInMemory () {
		super();
		initCategories();
		initGoods();
	}	

	public Good getGood(int index) {
		return goods.get(index);
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}
		
	private void initGoods(){
		goods = new ArrayList<Good>();
		goods.add(new Good(categories.get(0), "Fender Strat", 0));
		goods.add(new Good(categories.get(0), "Fender Tele", 1));
		goods.add(new Good(categories.get(0), "Gibson SG", 2));
		goods.add(new Good(categories.get(1), "Fender Rhodes", 3));
		goods.add(new Good(categories.get(1), "Korg MS-20", 4));
		goods.add(new Good(categories.get(2), "VOX Overdrive", 5));
	}
	
	private void initCategories(){
		categories = new ArrayList<Category>();
		categories.add(new Category("Guitars"));
		categories.add(new Category("Synths"));
		categories.add(new Category("Other"));		
	}
	
}
