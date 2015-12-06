package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class CategoryDaoFileImplTest {
	private File testCategoriesFile;
	private CategoryDaoFileImpl CategoryDaoFileImpl;
	private static final String PATH = "./././src/test/resources/";

	@Test
	public void testGetCategories() {
		testCategoriesFile = new File(PATH + "categories.csv");
		CategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(CategoryDaoFileImpl.getCategories().size(), is(3));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNotcategoriesInFile() {
		testCategoriesFile = new File(PATH + "nocategories.csv");
		CategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		CategoryDaoFileImpl.getCategories();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNocategoriesFile() {
		testCategoriesFile = new File(PATH + "notExistentcategories.csv");
		CategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		CategoryDaoFileImpl.getCategories();
	}

	@Test
	public void testGetCategory() {
		testCategoriesFile = new File(PATH + "categories.csv");
		CategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(CategoryDaoFileImpl.getCategory(3).getName(), is("Categ3"));
	}

	@Test
	public void testSize() {
		testCategoriesFile = new File(PATH + "categories.csv");
		CategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(CategoryDaoFileImpl.size(), is(3));
	}
}
