package mainkick;

import static org.junit.Assert.*;

import java.util.Arrays;

import model.Categories;
import model.Projects;
import model.ReaderDB;

import org.junit.Test;

public class TestCategoriesClass {
	Categories categories = new Categories();
	{
		categories.writeAllCatecories();
		categories.getKickCategories();
		categories.projectsContain(0);
		categories.showCatecoryName(0);
	}
	
	@Test
    public void shouldAllCatecories_whenNotAllCatecories(){
		String s = categories.getStringAllCatecories();
		assertTrue(s.equals("1 Category-1\n2 Category-2\n3 Category-3"));
    }
	
	@Test
    public void shouldKickContainCategory_whenNotKickContainCategory(){
		int[] i = categories.getKickCategories();
		int[] j = {1, 2, 3};
		assertTrue(Arrays.equals(i, j));
    }
	
	@Test
    public void shouldProjectsContain_whenProjectsContain(){
		int[] i = categories.projectsContain(0);
		int[] j = {1, 3, 4};
		assertTrue(Arrays.equals(i, j));
    }
	
	@Test
    public void shouldFirstCatecoryName_whenNotFirstCatecoryName(){
		String s = categories.showCatecoryName(0);
		assertTrue(s.equals("Category-1"));
    }
	
	@Test
    public void shouldAllProjectInCategory_whenNotAllProjectInCategory(){
		Projects projects = new Projects();
		projects.writeAllProjects();
		String s = categories.showAllProjectInCategory(0, projects);
		assertTrue(s.equals("1, Progect-1, shortDescription-1, 1000, 10\n"
				+ "3, Progect-3, shortDescription-3, 1000, 10\n"
				+ "4, Progect-4, shortDescription-4, 1000, 10"));
    }
	
	@Test//(expected = FileNotFoundException.class)
    public void shouldFileNotFoundException_whenNotFileNotFoundException(){
		ReaderDB reader = new ReaderDB();
		reader.read("Categories.properties");
    }
}