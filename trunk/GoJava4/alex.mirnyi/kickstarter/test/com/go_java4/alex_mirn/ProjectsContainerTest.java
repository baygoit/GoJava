package com.go_java4.alex_mirn;


	import static org.junit.Assert.*;

	import org.junit.Test;

	import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data_containers.EntityContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;

	public class ProjectsContainerTest extends EntityContainer {
		
		@Test
		public void shouldEmptyProjectsList_whenCreate() {
			ProjectsContainer list = new ProjectsContainer();
				
			assertEquals("[]", list.getData().toString());
		}
		
		
		@Test
		public void shouldGetProjectByIndex_whenAddProjectToList() {
			ProjectsContainer list = new ProjectsContainer();
			
			Project project1 = new Project(1, new Category(1, "Category1"), "name1", "description1", 1, 2, 3);
			Project project2 = new Project(2, new Category(2, "Category2"), "name2", "description2", 1, 2, 3);			
			
			list.add(project1); 
			list.add(project2); 
			
			assertSame(project1, list.get(0));
			assertEquals(project2, list.get(1));
		}

		@Test
		public void returnToString_WhenCreatedandAskForToString() {
			Project project1 = new Project(1, new Category(1, "Category1"), "name1", "description1", 1, 2, 3);
			
			assertEquals("Project number: 1" + "\n" +
"Project name: name1" + "\n" +
"Short Description: description1" + "\n" +
"Total sum needed: 1$" + "\n" +
"Pledged: 1$" + "\n" +
"Days to go: 3" + "\n", project1.toString());
		}
		//		@Override
//		public String toString() {
//			return "Project number: " + projectId + "\n" + "Project name: " + name
//					+ "\n" + "Short Description: " + shortDescription + "\n"
//					+ "Total sum needed: " + totalSum + "$" + "\n" + "Pledged: "
//					+ totalSum + "$" + "\n" + "Days to go: " + daysLeft + "\n";
//		}
//
//		public int getProjectId() {
//			return projectId;
//		}
//
//		public Category getCategory() {
//			return category;
//		}
//
//		public void setHistory(String history) {
//			this.history = history;
//		}
//
//		public void setVideoLink(String videoLink) {
//			this.videoLink = videoLink;
//		}
//
//		public void setQuestions(String questions) {
//			this.questions = questions;
//		}
	}