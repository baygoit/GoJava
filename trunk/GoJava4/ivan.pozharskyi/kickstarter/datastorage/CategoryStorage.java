package com.ivanpozharskyi.kickstarter.datastorage;

public class CategoryStorage {
	private static final int AMOUNT_OF_CATEGORYS = 9;
	private Category [] categorys = new Category[AMOUNT_OF_CATEGORYS]; 
	private int size = 0;
	
	public Category getCategory(int index){
		return categorys[index];
	}
	public void addCategory(Category category){
		categorys[size++] = category;
	}
	public Category [] getAllCategorys(){
		return categorys;
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i=0; i < size; i++){
			result.append(categorys[i].toString());
		}
		return result.toString();
	}
	
}
