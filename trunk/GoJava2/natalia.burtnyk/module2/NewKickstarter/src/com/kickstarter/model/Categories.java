package com.kickstarter.model;

import java.util.List;

public interface Categories {

	void add(Сategory category);

	List<Сategory> getCategories();

	Сategory get(int index);

	int size();

}
