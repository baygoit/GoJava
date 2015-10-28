package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sergiisavin.kickstarter.category.Category;
import com.sergiisavin.kickstarter.category.container.file.CategoriesContainerFile;

public class CategoriesContainerFileTest {

	private static final String PATH = System.getProperty("user.dir"); 
	private static final String FILE_NAME = "categories.dat";
	private static final String FILE = PATH + "\\" + FILE_NAME;
	
	CategoriesContainerFile categories;
	
	@Before
	public void test() {
		categories = new CategoriesContainerFile();
		assertNotNull(categories);
	}
	
	@Ignore
	@Test()
	public void createAndFillCategoriesFile(){
		categories = new CategoriesContainerFile("My Category 1", "My Category 2", "My Category 3");
		
		BufferedReader reader;
		String category = null;
		String categoriesOneLine = "";
		
		try {
			reader = new BufferedReader(new FileReader(FILE));
			while( (category = reader.readLine()) != null){
				categoriesOneLine += category;
			}
			assertEquals("My Category 1My Category 2My Category 3", categoriesOneLine);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addCategoryByStringNameThrowsException() throws OperationNotSupportedException{
		categories.add("New Category");
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addCategoryByCategoryObjectThrowsException() throws OperationNotSupportedException{
		categories.add(new Category("New Category"));
	}

	@Test
	public void getSize(){
		int size = categories.getSize();
		assertEquals(3, size);
	}
	
	@Test
	public void getCategory(){
		Category category = categories.get(1);
		System.out.println(category);
	}
}
