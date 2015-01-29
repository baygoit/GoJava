package test;

import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;

import mainkick.Category;
import mainkick.Quotes;

import org.junit.Test;

public class ListOfCategories {
	@Test 
	public void shouldListOfProjects_expectedListOfProjectsIsEmpty() throws FileNotFoundException {
		Category cat = new Category();
		cat.showAllCatecories();
		assertFalse(); 
	 }
}
