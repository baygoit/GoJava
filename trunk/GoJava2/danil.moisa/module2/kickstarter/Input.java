package kickstarter;

import java.util.Scanner;

public class Input {
	private Scanner scan;
//	private ProjectList projectList= new ProjectList();
	public void choiceCategory() {
			scan = new Scanner(System.in);
			int i = scan.nextInt();
			switch (i) {
			case (1):
				System.out.println("••• Вы выбрали Спорт!");
				ProjectList.showSportProjects();
				break;
			case (2):
				System.out.println("••• Вы выбрали Музыку!");
				ProjectList.showMusicProjects();
				break;
			case (3):
				System.out.println("••• Вы выбрали Технику!");
				ProjectList.showTechProjects();
				break;

			default:
				System.out
						.println("Такой категории не существует! Выберите, пожалуйста, другую из выше перечисленных!");
				break;
			}

		
	}

	public void choiceProject() {
			int i = scan.nextInt();
			switch (i) {
			case (1):
				
				break;
			case (2):
				
				break;
			case (3):
				
				break;

			default:
				System.out.println("Нет такого проекта :(");
				break;
			}

		
	}
}
