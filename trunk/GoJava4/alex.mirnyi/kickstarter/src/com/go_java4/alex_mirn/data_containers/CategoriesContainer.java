package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data_containers.EntityContainer;

public class CategoriesContainer extends EntityContainer<Category>{

	public CategoriesContainer() {
		data = new ArrayList<Category>();
	}
	
}
