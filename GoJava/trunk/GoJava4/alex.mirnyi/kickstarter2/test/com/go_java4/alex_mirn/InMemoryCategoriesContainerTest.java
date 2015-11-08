package com.go_java4.alex_mirn;

import com.go_java4.alex_mirn.data_containers.CategoriesContainer;

public class InMemoryCategoriesContainerTest extends CategoriesContainerTest{

	@Override
	CategoriesContainer getContainer() {
		return new CategoriesContainer();
	}

}
