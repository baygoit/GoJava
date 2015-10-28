package com.sergiisavin.kickstarter.category.container.memory;

import com.sergiisavin.kickstarter.category.Category;
import com.sergiisavin.kickstarter.category.container.Categories;

public class CategoriesContainer implements Categories {

	private Category[] categories;
	private int numberOfCategoriesStored;
	private static final int INCREASE_ARRAY_SIZE_FACTOR = 2;
	
	public CategoriesContainer(String ... categoryNames){
		this.categories = new Category[categoryNames.length];
		for(String categoryName : categoryNames){
			add(categoryName);
		}
		numberOfCategoriesStored = categoryNames.length;
	}
	
	@Override
	public void add(String categoryName) {
		if(categoryName == null){
			throw new Categories.IllegalArgumentException();
		}
		if(categories.length == numberOfCategoriesStored){
			doubleSizeAndCloneCategories();
		}
		categories[numberOfCategoriesStored] = new Category(categoryName); 
		numberOfCategoriesStored++;
	}

	private void doubleSizeAndCloneCategories() {
		Category[] tmp = new Category[(categories.length)*INCREASE_ARRAY_SIZE_FACTOR];
		System.arraycopy(categories, 0, tmp, 0, categories.length);
		categories = tmp;
	}

	@Override
	public void add(Category category) {
		if(category == null){
			throw new Categories.IllegalArgumentException();
		}
		if(categories.length == numberOfCategoriesStored){
			doubleSizeAndCloneCategories();
		}
		categories[numberOfCategoriesStored] = category; 
		numberOfCategoriesStored++;
	}

	@Override
	public Category get(int i) {
		if(i < 0){
			throw new Categories.IllegalArgumentException();
		}
		Category result = null;
		if(i < numberOfCategoriesStored && i >= 0){
			result = categories[i];
		}
		return result;
	}

	@Override
	public int getSize() {
		return numberOfCategoriesStored;
	}
	
	@Override
	public String toString(){
		StringBuffer result = new StringBuffer();
		for(int index = 0; index < numberOfCategoriesStored; index++){
			result.append(categories[index].toString());
			result.append(" ");
		}
		return result.toString();
	}
	
}
