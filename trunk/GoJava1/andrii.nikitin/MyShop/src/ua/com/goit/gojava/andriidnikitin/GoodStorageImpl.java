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
		String categoryName = category.getName();
		for (Good good : goodList){
			if (categoryName.equals(category.getName())) { 
					result.add(good);
			}
		}
		return result;
	}
	
	@Override
	public boolean categoryExists(Category category){
		if ((category == null) || (categoryList == null)) {
			return false;			
		}
		boolean answer = false;
		for (int i = 0; i < categoryList.size(); i++){			
			if (categoryList.get(i).getName().equals(category.getName())) {
				answer = true;
			}
		}
		return answer;		
	}
	
	@Override
	public boolean goodExists(Good good){
		if ((good == null) || (goodList == null)) {
			return false;			
		}
		boolean answer = false;
		for (int i = 0; i < goodList.size(); i++){			
			if (goodList.get(i).getId().equals(good.getId())) {
				answer = true;
			}
		}
		return answer;		
	}
	
	
	@Override
	public void addCategory (Category category) {
		if (category == null) {
			throw new IllegalArgumentException("Invalid argument: added category is null");
		}		
		if  (categoryList == null) {
			throw new NullPointerException("List of categories is not initialised.");
		}		
		if (!categoryExists(category)){
			categoryList.add(category);
		}
		else {
			throw new IllegalArgumentException("You are trying to add existing category.");
		}
	}

	@Override
	public void addGood(Good good) {
		if (good == null) {
		throw new IllegalArgumentException("Invalid argument: added good is null");
		}
			
		if  (goodList == null) {
			throw new NullPointerException("List of goods is not initialised.");
		}
		
		if (!categoryExists(good.getCategory())){
			throw new IllegalArgumentException("You are trying to add "
					+ "good from unexisting category");
		}
		
		if (!goodExists(good)){
			goodList.add(good);
		}
		else{
			throw new IllegalArgumentException("You are trying to add existing item.");
		}
			
	}	
	
	public void updateCategory(Category oldCategory, Category newCategory) {
		
	}
	
	public void updateGood(Good oldGood, Good newGood) {
		if (goodExists(oldGood)) {
			
		}
		
		else {
			throw new IllegalArgumentException("Such good does not exist.");
		}
		
		oldGood.setCategory(newGood.getCategory());
		oldGood.setId(newGood.getId());
		oldGood.setName(newGood.getName());
	}	
	
	public void updateCategoty (Category oldCategory, Category newCategory) {
		if (categoryExists(oldCategory)) {
			
		}
		
		else {
			throw new IllegalArgumentException("Such good does not exist.");
		}

		oldCategory.setName(newCategory.getName());
	}	
}
