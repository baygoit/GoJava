package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.List;

public class GoodStorageInMemory implements GoodStorage {
	
	private List<Good> goodList;
	
	private List<Category> categoryList;
	
	public GoodStorageInMemory () {
		super();
		initCategories();
		initGoods();
	}
	
	public List<Good> getGoodList() {
		return goodList;
	}
	
	
	public List<Good> getGoodList(Category category) {
		if ((category == null ) || (!categoryList.contains(category)) ){
			return null;
		}
		List<Good> listOfGoods = new ArrayList<Good>();
		for (Good tempGood : goodList){
			if (tempGood.getCategory() == category)
				listOfGoods.add(tempGood);
		}
		return listOfGoods;
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	private void initGoods(){
		goodList = new ArrayList<Good>();
		goodList.add(new Good(categoryList.get(0), "Fender Strat", 0));
		goodList.add(new Good(categoryList.get(0), "Fender Tele", 1));
		goodList.add(new Good(categoryList.get(0), "Gibson SG", 2));
		goodList.add(new Good(categoryList.get(1), "Fender Rhodes", 3));
		goodList.add(new Good(categoryList.get(1), "Korg MS-20", 4));
		goodList.add(new Good(categoryList.get(2), "VOX Overdrive", 5));
	}
	
	private void initCategories(){
		categoryList = new ArrayList<Category>();
		categoryList.add(new Category("Guitars"));
		categoryList.add(new Category("Synths"));
		categoryList.add(new Category("Other"));		
	}
	
}
