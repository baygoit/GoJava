package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class TestFileCategoryReader {
	private File testCategoriesFile;
	private FileCategoryReader fileCategoryReader;

	@Test
	public void testGetCategories() {
		testCategoriesFile = new File("./resources/categories.csv");
		fileCategoryReader = new FileCategoryReader(
				testCategoriesFile);
		assertThat(fileCategoryReader.getCategories().size(), is(3));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNotcategoriesInFile() {
		testCategoriesFile = new File("./resources/nocategories.csv");
		fileCategoryReader = new FileCategoryReader(
				testCategoriesFile);
		fileCategoryReader.getCategories();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNocategoriesFile() {
		testCategoriesFile = new File("./resources/notExistentcategories.csv");
		fileCategoryReader = new FileCategoryReader(
				testCategoriesFile);
		fileCategoryReader.getCategories();
	}
	
	@Test
	public void testGetProject() {
		testCategoriesFile = new File("./resources/categories.csv");
		fileCategoryReader = new FileCategoryReader(
				testCategoriesFile);
		assertThat(fileCategoryReader.getCategory(3).getName(), is("Categ3"));
	}
	
	@Test
	public void testSize() {
		testCategoriesFile = new File("./resources/categories.csv");
		fileCategoryReader = new FileCategoryReader(
				testCategoriesFile);
		assertThat(fileCategoryReader.size(), is(3));
	}
}
