package kickstarter;

import java.util.ArrayList;

public class ProjectLists {
	private Output out = new Output();

	public static ArrayList<Project> ProjectList = new ArrayList<Project>();
//	public static ArrayList<Project> choiceProjectList = new ArrayList<Project>();

	public ProjectLists() {
		ProjectList.add(new Project(1, "Идивидуальные сноуборды", 5000,
				"Любой принт на Вашем сноуборде!", 3450, 5, null, null, null));
		ProjectList.add(new Project(1, "Боулинг", 4000, "Выездной боулинг!",
				3250, 23, null, null, null));

		ProjectList.add(new Project(2, "Запись альбома", 5000,
				"Пишем дебютный альбом с улетной музыкой!", 3450, 5, null,
				null, null));
		ProjectList.add(new Project(2, "Муз.инстр.", 50000,
				"Цех по производству ультрасовременных инструментов!", 1000,
				13, null, null, null));

		ProjectList.add(new Project(3, "3D - printer", 5000000,
				"3Д печать в каждый дом! Портативные 3д принтеры!", 300000, 25,
				null, null, null));
		ProjectList
				.add(new Project(
						3,
						"Машинка",
						100000,
						"Радиоуправляемая машина оснащенна камерой, с большим радиусом действия!",
						13250, 23, null, null, null));
	}
	public int getId(int choice) {
		return getId(choice);
	}
	public void showProjects(int choice) {
		int index = 1;
		for (int j = 0; j < ProjectList.size(); j++) {
			int k = ProjectList.get(j).getId();
			if (k == choice) {
				out.print(index + ". " + ProjectList.get(j).toString());
				index++;
			}
		}
	}

	public void showProjectFull(int choice) {
		out.print("You pick: \n" + ProjectList.get(choice).allToString());
	}
	
	public void showTitle(int choice) {
		out.print(ProjectList.get(choice - 1).getTitle());
	}

	
}
