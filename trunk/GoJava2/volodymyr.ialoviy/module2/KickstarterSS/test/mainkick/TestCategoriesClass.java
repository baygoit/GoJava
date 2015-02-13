package mainkick;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class TestCategoriesClass {
	Categories categories = new Categories();
	Category category = new Category();
	{
		categories.readAllCatecories();
		categories.kickContainCategory();
		category.projectsContain(0, categories);
		category.showCatecoryName(0, categories);
	}
	
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
		int[] i = category.projectsContain(0, categories);
		int[] j = {1, 3, 4};
		assertTrue(Arrays.equals(i, j));
    }
	
	@Test
    public void shouldFirstCatecoryName_whenNotFirstCatecoryName() throws IOException, InterruptedException{
		String s = category.showCatecoryName(0, categories);
		assertTrue(s.equals("Category-1"));
    }
	
	@Test
    public void shouldAllProjectInCategory_whenNotAllProjectInCategory() throws IOException, InterruptedException{
		Projects projects = new Projects();
		projects.writeAllProjects();
//		Project project = new Project();
		String s = category.showAllProjectInCategory(0, projects, categories);//TODO project поменял на projects
		assertTrue(s.equals("1, Progect-1, shortDescription-1, 1000, 10\n"
				+ "3, Progect-3, shortDescription-3, 1000, 10\n"
				+ "4, Progect-4, shortDescription-4, 1000, 10"));
    }
	
	@Test(expected = FileNotFoundException.class)
    public void shouldFileNotFoundException_whenNotFileNotFoundException() throws IOException, InterruptedException{
		ReaderBD reader = new ReaderBD();
		reader.read("Categories1.properties");
    }
}