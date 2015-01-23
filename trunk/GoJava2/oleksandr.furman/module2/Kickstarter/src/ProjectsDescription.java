import java.util.ArrayList;


public class ProjectsDescription {
	public void projectsDescription(ArrayList<String> project) {
		System.out.println("Название проекта: " + project.get(0));
		System.out.println("Описание проекта: " + project.get(1));
		System.out.println("Сумма необходимая для сбора: $" + Integer.parseInt(project.get(2)));
		System.out.println("Собранная сумма: $" + Integer.parseInt(project.get(3)));
		System.out.println("Дни до конца сбора средств: " + Integer.parseInt(project.get(4)));
	}
	public void projectsFullDescription(ArrayList<String> project) {
		projectsDescription(project);
		System.out.println("История проекта: " + project.get(5));
		System.out.println("Линк на видео с демо: " + project.get(6));
		System.out.println("Вопросы/ответы: " + project.get(7));
		System.out.println("0 - Выход");
	}
}
