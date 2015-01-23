package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.List;

public class GoodStorageImpl implements GoodStorage {
	
	@SuppressWarnings("serial")
	private List<Category> categoryList = new ArrayList<Category>(){{
		this.add(new Category("Guitars"));
		this.add(new Category("Synths"));
		this.add(new Category("Other"));		
	}};
	
	@SuppressWarnings("serial")
	private List<Good> goodList = new ArrayList<Good>() {{
		this.add(new Good(0, "Fender Strat", categoryList.get(0)));
		this.add(new Good(1, "Fender Tele", categoryList.get(0)));
		this.add(new Good(2, "Gibson SG", categoryList.get(0)));
		this.add(new Good(3, "Fender Rhodes", categoryList.get(1)));
		this.add(new Good(4, "Korg MS-20", categoryList.get(1)));
		this.add(new Good(5, "VOX Overdrive", categoryList.get(2)));
	}};
		
	public List<Good> getGoodList() {
		return goodList != null ? goodList : new ArrayList<Good>();		
	}	
	
	public List<Category> getCategoryList() {
		if (categoryList != null) {
			return categoryList;
		}
		else {
			return new ArrayList<Category>();
		}
	}
	
	public List<Good> getGoodList(Category category) {
		final List<Good> result = new ArrayList<Good>();
		if (category == null) {	
			return result;			
		}		
		for (Good good : goodList){
			if (good.getCategory().equals(category)) {	
				result.add(good);
			}
		}
		return result;
	}	
	
}
