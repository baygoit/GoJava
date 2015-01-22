
package ua.com.goit.gojava.kickstarter;

public class Projects {

	// по аналогии с категориями нам надо массив, который пока будет длинной, скажем 100
	private Project[] projects = new Project[100];
	// и количество сохраненных проектов
	private int count = 0;
	
	public void add(Project project) {
		projects[count] = project;
		count++;
	}

	public Project[] getProjects(Category category) {
		// дальше у нас надо пройтись по всем проектам и посмотреть, какой проект подходит и предложить его как кандидат на выход
		Project[] result = new Project[100];
		int found = 0;
		// проходимсмя по всем проектам
		for (int index = 0; index < count; index ++) {
			// если категория проекта такая как мы хотим, то
			Project project = projects[index];
			if (project.getCategory().equals(category)) {
				// добавляем проект в результирующий массив
				result[found] = project;
				// инкрементим индекс
				found++;
			}
		}
		// но тут у нас массив будет заполнен не полностью. с 0 по found - 1 - там полезная инфа, а потом все забито null
		// надо бы обрезать
		Project[] result2 = new Project[found];
		System.arraycopy(result, 0, result2, 0, found);
		return result2;
	}

}
