package ua.com.sas.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.sas.dao.Categories;

public abstract class CategoriesTest {

	private Categories list;

	@Before
	public void start() {
		list = getList();
	}

	abstract Categories getList();

//	@Test
//	public void shouldMakeList_whenCategoryAdded() {
//		//given
//		List<Category> categories = new ArrayList<Category>();
//
//		// when
//		Category category1 = new Category("Category1");
//		Category category2 = new Category("Category2");
//		list.add(category1);
//		list.add(category2);
//		categories.add(category1);
//		categories.add(category2);
//
//		// then
//		assertEquals(categories, list.getCategories());
//	}
//
//	@Test
//	public void shouldBeEmptyArray_whenNoOneCategoryInIt() {
//		// then
//		assertEquals(0, list.size());
//	}
//
//	@Test
//	public void shouldGetArraysLenth_whenItHasCategories() {
//		// given
//		Category category1 = new Category("Category1");
//		Category category2 = new Category("Category2");
//		list.add(category1);
//		list.add(category2);
//		// then
//		assertEquals(2, list.size());
//	}
//
//	@Test
//	public void shouldGetCategoryByIndex_whenItAdded() {
//		// when
//		Category category1 = new Category("category1");
//		Category category2 = new Category("Category2");
//		list.add(category1);
//		list.add(category2);
//
//		// then
//		assertEquals(category1, list.get(category1.getId()));
//		assertEquals(category2, list.get(category2.getId()));
//	}

}