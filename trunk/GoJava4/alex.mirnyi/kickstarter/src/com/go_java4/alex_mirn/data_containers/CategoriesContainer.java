package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data_containers.EntityContainer;

public class CategoriesContainer extends EntityContainer<Category>{
//	private List<Category> data;

	public CategoriesContainer() {
		data = new ArrayList<Category>();
	}

//	public Category get(int index) {
//		return (Category) data.get(index);
//	}

//	public int size() {
//		return data.size();
//	}

//	public void add(Category category) {
//		data.add(category);
//	}

//	public List<Category> getCategories() {
//		return data;
//	}
	
}
