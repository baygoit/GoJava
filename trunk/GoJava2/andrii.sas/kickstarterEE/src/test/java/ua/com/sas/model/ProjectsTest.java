//package ua.com.sas.model;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public abstract class ProjectsTest {
//	
//	private Projects projects;
//	private Category category1;
//	private Project project1;
//	private Category category2;
//	private Categories categories;
//
//	@Before
//	public void start(){
//		projects = getProjects();
//		categories = getCategories();
//		category1 = new Category("category1");
//		categories.add(category1);
//		category2 = new Category("category2");
//		categories.add(category2);
//		project1 = new Project(category1);
////		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
//		project1.setCategoryId(category1.getId());
//		
//	}
//	
//	abstract Projects getProjects();
//	
//	abstract Categories getCategories();
//	
//	@Test
//	public void shouldGetProjectById(){
//		//when
//		projects.add(project1);
//		Project project3 = projects.get(project1.getId());
//		
//		//then
//		assertEquals(project1, project3);
//	}
//	
//
//	@Test
//	public void shouldReturnListOfSelectedCategoryProjects_whenTwoProjectsWithDifferentCategoriesInitialized(){
//		//given
//		List<Project> chosenProjects = new ArrayList<Project>();
//		Project project2 = new Project(category2);
//		project2.setCategoryId(category2.getId());
//		
//		//when
////		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
//		projects.add(project1);
//		projects.add(project2);
//		chosenProjects.add(project2);
//		
//		//then
//		assertEquals(chosenProjects, projects.getProjects(category2));
//	}
//	
//	@Test
//	public void shouldBeEmpty_whenSelectedCategoryWithNoProjectsInIt(){
//		//when
//		Project project2 = new Project(category1);
//		project2.setCategoryId(category1.getId());
////		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
//		projects.add(project1);
//		projects.add(project2);
//		projects.getProjects(category2);
//		
//		//then
//		assertEquals(0, projects.size());
//	}
//	
//	@Test
//	public void shouldHaveTwoElements_whenSelectedCategoryWithTwoProjectsInIt(){
//		//when
//		Project project2 = new Project(category2);
//		project2.setCategoryId(category2.getId());
////		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
//		projects.add(project1);
//		projects.add(project2);
//		projects.getProjects(category2);
//		
//		//then
//		assertEquals(1, projects.size());
//	}
//	
//}