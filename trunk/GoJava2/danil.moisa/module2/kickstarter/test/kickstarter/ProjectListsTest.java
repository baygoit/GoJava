package kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectListsTest {

	@Test
	public void shouldProjectList_whenAddProject() {
		ArrayList<Project> projectList = new ArrayList<Project>();
		
		Project project1 = new Project(0, null, 10, null, 0, 0, null, null, null);
		projectList.add(0, project1);
		String s = "[" + null + "\n" + "Полное описание проекта: " + null + "\n"
				+ "Необходимо собрать: " + 10 + "грн" + "\n"
				+ "Мы уже собрали: " + 0 + "грн" + "\n"
				+ "Осталось дней до закрытия: " + 0 + "\n" + "]";
		assertEquals(s, projectList.toString());

	}
	@Test
	public void shouldAllInfoProject_whenAllToString() {
		ArrayList<Project> projectList = new ArrayList<Project>();
		
		Project project1 = new Project(0, null, 10, null, 0, 0, null, null, null);
		projectList.add(0, project1);
		
		String s1 = null + "\n" + "Полное описание проекта: " + null + "\n"
				+ "Необходимо собрать: " + 10 + "грн" + "\n"
				+ "Мы уже собрали: " + 0 + "грн" + "\n"
				+ "Осталось дней до закрытия: " + 0 + "\n" + "••••• Дополнительная информация: " + "\n" + "Демо видео проекта: "
				+ null + "\n" + "История нашего проекта: " + "\n" + null
				+ "\n" + "FAQ: " + "Еще не было вопросов по данному проекту! \n Вы можете задать вопросы по проекту! \n Мы ответим на них в кратчайшие сроки" + "\n";
		assertEquals(s1, project1.allToString());

	}
	
	@Test
	public void shouldProjectList_whenNoProject() {
		ArrayList<Project> projectList = new ArrayList<Project>();

		assertEquals("[]", projectList.toString());

	}

@Test
public void shouldReturnProjectId_whenAddProject() {
	ArrayList<Project> projectList = new ArrayList<Project>();
	
	Project project1 = new Project(0, null, 10, null, 0, 0, null, null, null);
	projectList.add(0, project1);

	assertEquals(0, project1.getId());

}
@Test
public void shouldReturnProjectTitle_whenAddProject() {
	ArrayList<Project> projectList = new ArrayList<Project>();
	
	Project project1 = new Project(0, "Title", 10, null, 0, 0, null, null, null);
	projectList.add(0, project1);

	assertEquals("Title", project1.getTitle());

}
}
