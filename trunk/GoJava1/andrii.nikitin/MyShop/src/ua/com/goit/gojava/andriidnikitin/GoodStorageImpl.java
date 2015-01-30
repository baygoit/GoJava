package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.List;

public class GoodStorageImpl implements GoodStorage {
	
	@SuppressWarnings("serial")
	private List<Category> categoryList = new ArrayList<Category>(){{
		this.add(setId(new Category("Guitars")));
		this.add(setId(new Category("Synths")));
		this.add(setId(new Category("Other")));		
	}};
	
	@SuppressWarnings("serial")
	private List<Good> goodList = new ArrayList<Good>() {{
		this.add(setId(new Good(0, "Fender Strat", categoryList.get(0))));
		this.add(setId(new Good(1, "Fender Tele", categoryList.get(0))));
		this.add(setId(new Good(2, "Gibson SG", categoryList.get(0))));
		this.add(setId(new Good(3, "Fender Rhodes", categoryList.get(1))));
		this.add(setId(new Good(4, "Korg MS-20", categoryList.get(1))));
		this.add(setId(new Good(5, "VOX Overdrive", categoryList.get(2))));
	}};
	
	public GoodStorageImpl() {
		
	}
	
	protected GoodStorageImpl setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
		return this;
	}

	protected GoodStorageImpl setGoodList(List<Good> goodList) {
		this.goodList = goodList;
		return this;
	}
	
	protected List<Good> getGoodList() {
		return goodList != null ? goodList : new ArrayList<Good>();		
	}	
	
	@Override
	public List<Category> getCategoryList() {
		return categoryList != null ? categoryList : new ArrayList<Category>();
	}
	
	@Override
	public List<Good> getGoodList(Category category) {
		final List<Good> result = new ArrayList<Good>();
		if (category == null || category.getName() == null) { 
				return result;   
		}  
		for (Good good : goodList){
			if (category.getId().equals(good.getCategory().getId())) { 
					result.add(good);
			}
		}
		return result;
	}

	@Override
	public void save (Category category) {
		if (category.getId() == null) {
			categoryList.add(setId(category));
		}
		else {
			for (int index = 0; index < categoryList.size(); index++) {
				if (category.getId().equals(categoryList.get(index).getId())) {
					categoryList.set(index, category);
					break;
				}
			
			}		
		}
	}

	@Override
	public void save (Good good) {
		if (good.getId() == null) {
			goodList.add(setId(good));
		}
		else {
			for (int index = 0; index < goodList.size(); index++) {
				if (good.getId().equals(goodList.get(index).getId())) {
					goodList.set(index, good);
					break;
				}
			
			}		
		}
		
	}
	
	private Category setId (Category category) {
		if (category == null) {
			return null;
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + category.getName().hashCode();
		return category.setId(result);
	}
	
	private Good setId(Good good) {
		final int prime = 31;
		int result = 1;
		Category category = good.getCategory();
		result = prime * result + category.getId();
		result = prime * result + good.getName().hashCode();
		return good.setId(result);
	}
}