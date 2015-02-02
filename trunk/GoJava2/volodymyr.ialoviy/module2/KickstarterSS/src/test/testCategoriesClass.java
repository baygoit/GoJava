package test;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import mainkick.Categories;

public class testCategoriesClass {
	Categories categories = new Categories();
	{try {
		categories.showAllCatecories();
		categories.kickContainCategory();
		categories.projectsContain(0);
		categories.showCatecoryName(0);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}}
	
	@Test
    public void shouldAllCatecories_whenNotAllCatecories() throws IOException, InterruptedException{
		String s = categories.showAllCatecories();
		assertTrue(s.equals("1 Category-1\n2 Category-2\n3 Category-3"));
    }
	
	@Test
    public void shouldKickContainCategory_whenNotKickContainCategory() throws IOException, InterruptedException{
		int[] i = categories.kickContainCategory();
		int[] j = {1, 2, 3};
		assertTrue(Arrays.equals(i, j));
    }
	
	@Test
    public void shouldProjectsContain_whenProjectsContain() throws IOException, InterruptedException{
		int[] i = categories.projectsContain(0);
		int[] j = {1, 3, 4};
		System.out.println(Arrays.toString(i));
		assertTrue(Arrays.equals(i, j));
    }
	
	@Test
    public void shouldFirstCatecoryName_whenNotFirstCatecoryName() throws IOException, InterruptedException{
		String s = categories.showCatecoryName(0);
		assertTrue(s.equals("Category-1"));
    }
	
}