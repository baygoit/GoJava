package ua.com.goit.gojava.andriidnikitin.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public class StorageImpl extends StorageAbstract {

	private List<Category> categoryList;
	private List<Good> goodList;
	
	public StorageImpl() {
		init();
	}
	
	protected StorageImpl setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
		return this;
	}

	protected StorageImpl setGoodList(List<Good> goodList) {
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
	
	@SuppressWarnings("serial")
	private void init() {
		categoryList = new ArrayList<Category>(){{
			this.add(setId(new Category()
						.setName("Guitars")));
			this.add(setId(new Category()
						.setName("Synths")));
			this.add(setId(new Category()
						.setName("Other")));		
		}};
		
		goodList = new ArrayList<Good>() {{
			Good tempGood;
			tempGood = new Good()	
					.setName("Fender Strat")
					.setCategory(categoryList.get(0))
					.setPrice(new BigDecimal(1000.0));
			this.add(setId(tempGood));
			
			tempGood = new Good()	
					.setName("Fender Tele")
					.setCategory(categoryList.get(0))
					.setPrice(new BigDecimal(1200.0));
			this.add(setId(tempGood));
			
			tempGood = new Good()	
					.setName("Gibson SG")
					.setCategory(categoryList.get(0))
					.setPrice(new BigDecimal(1337.0));
			this.add(setId(tempGood));

			tempGood = new Good()	
					.setName("Fender Rhodes")
					.setCategory(categoryList.get(1))
					.setPrice(new BigDecimal(3000.0));
			this.add(setId(tempGood));
			

			tempGood = new Good()	
					.setName("Korg MS-20")
					.setCategory(categoryList.get(1))
					.setPrice(new BigDecimal(2500.0));
			this.add(setId(tempGood));

			tempGood = new Good()	
					.setName("Marshall Drive")
					.setCategory(categoryList.get(2))
					.setPrice(new BigDecimal(300.0));
			this.add(setId(tempGood));
			}};
	}
}