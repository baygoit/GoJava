package com.go_java4.alex_mirn;


	import static org.junit.Assert.*;

	import java.awt.List;
	import java.util.Arrays;


	import org.junit.Test;

	import com.go_java4.alex_mirn.data.Category;
	import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
	import com.go_java4.alex_mirn.data.Project;
	import com.go_java4.alex_mirn.data_containers.ProjectsContainer;

	public class ProjectsTest {
		
		@Test
		public void shouldEmptyProjectsList_whenCreate() {
			ProjectsContainer list = new ProjectsContainer();
				
			assertEquals("[]", list.getProjects().toString());
		}
		
		
		@Test
		public void shouldGetProjectByIndex_whenAddProjectToList() {
			ProjectsContainer list = new ProjectsContainer();
			
			Project project1 = new Project(new Category("Category1"), "name1", "description1", 1, 2, 3);
			Project project2 = new Project(new Category("Category2"), "name2", "description2", 1, 2, 3);			
			
			list.add(project1); 
			list.add(project2); 
			
			assertSame(project1, list.get(0));
			assertEquals(project2, list.get(1));
		}
		
		@Test
		public void shouldReturnSizeOfContainer_whenAskForIt() {
			ProjectsContainer list = new ProjectsContainer();
			
			assertEquals(0, list.size());
			
			Project project1 = new Project(new Category("Category1"), "name1", "description1", 1, 2, 3);
			Project project2 = new Project(new Category("Category2"), "name2", "description2", 1, 2, 3);			
			
			list.add(project1); 
			list.add(project2);  
			
			assertEquals(2, list.size());
		}
	}