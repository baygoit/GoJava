package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectsTest {

	@Test // тест на то, что в пустом списке проектов ничего не найдем
	public void shouldEmptyProjects_whenNoProjects() {
		// given 
		Projects list = new Projects();
		
		// when
		Project[] found = list.getProjects(new Category("name"));
		
		// then
		assertEquals(0, found.length);
	}
	
	@Test // тест на то, что в списке проектов ничего не найдем, если не та категория
	public void shouldEmptyProjects_whenNoProjectsWithSameCategory() {
		// given 
		Category category = new Category("category");
		
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");
		project1.setCategory(category);
		
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		project2.setCategory(category);
		
		list.add(project1);
		list.add(project2);
		
		// when
		Project[] found = list.getProjects(new Category("name"));
		
		// then
		assertEquals(0, found.length);
	}
	
	@Test // хочу написать тест, в котором поиск получается, потому что категория совпадает
	public void shouldFoundProjects_whenExistsProjectWithCategory() {
		// given 
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		
		
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");
		project1.setCategory(category1); // этот нет
		
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		project2.setCategory(category2); // этот найдем
		
		Project project3 = new Project("name3", 300, 30, "video3", "description3");
		project3.setCategory(category2); // этот найдем
		
		list.add(project1);
		list.add(project2);
		list.add(project3);
		
		// when
		Project[] found = list.getProjects(category2);
		
		// then
		// assertEquals вызывает у объектов actual.equals(expected)
		assertEquals(2, found.length);
		// assertSame говорит что это два идентичных объъекта
		assertSame(project2, found[0]);
		assertSame(project3, found[1]);
	}
	
	@Test // тест в котором я дергаю проекты по их порядковому номеру
	public void shouldGetProject_whenExistsSomeProjects() {
		// given 
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");	
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		
		list.add(project1);
		list.add(project2);
		
		// when then
		assertSame(project1, list.get(0));
		assertSame(project2, list.get(1));
	}
	
}
