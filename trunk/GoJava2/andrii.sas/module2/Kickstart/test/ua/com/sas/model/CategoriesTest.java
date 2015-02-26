package ua.com.sas.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class CategoriesTest {

	private Categories list;

	@Before
	public void start() {
		list = getList();
	}

	abstract Categories getList();

	@Test
	public void shouldMakeList_whenCategoryAdded() {
		// when
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		list.addCategory(category1);
		list.addCategory(category2);

		// then
		assertEquals("1 - Category1, 2 - Category2", list.getCategories());
	}

	@Test
	public void shouldReturnEmptyString_whenNoOneCategories() {
		// when
		String categories = list.getCategories();

		// then
		assertEquals("", categories);
	}

	@Test
	public void shouldBeEmptyArray_whenNoOneCategoryInIt() {
		// then
		assertEquals(0, list.getLenth());
	}

	@Test
	public void shouldGetArraysLenth_whenItHasCategories() {
		// given
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		list.addCategory(category1);
		list.addCategory(category2);
		// then
		assertEquals(2, list.getLenth());
	}

	@Test
	public void shouldGetCategoryByIndex_whenItAdded() {
		// when
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		list.addCategory(category1);
		list.addCategory(category2);

		// then
		assertEquals(category1, list.readCategory(0));
		assertEquals(category2, list.readCategory(1));
	}

}