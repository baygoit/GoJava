
package ua.com.goit.gojava.kickstarter;

public class Projects {

	private Project[] projects = new Project[100];
	private int count = 0;
	
	public void add(Project project) {
		projects[count] = project;
		count++;
	}

	public Project[] getProjects(Category category) {
		Project[] result = new Project[100];
		int found = 0;
		for (int index = 0; index < count; index ++) {
			Project project = projects[index];
			if (project.getCategory().equals(category)) {
				result[found] = project;
				found++;
			}
		}
		Project[] result2 = new Project[found];
		System.arraycopy(result, 0, result2, 0, found);
		return result2;
	}

	// надо в хранилище реализовать этот метод - выдача проекта по индексу
	// подглянем как у нас это реализовано в категориях, потому как я уже забыл :) 
	// всю программу в голове держать не стоит - всегда можно подглядеть и сделать "по аналогии"
	// обычно вы будете на незнакомом проекте делать именно так
	public Project get(int index) {
		return projects[index]; // по аналогии, теперь вернемся на уровень выше  
	}

}
