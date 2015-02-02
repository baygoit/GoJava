package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects; 

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	// метод надо сделать пабликом, чтобы его было визно запределами класса. Это жеж наш основной класс
	public void run() {		
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
		
		// итак тут у нас реализована логика работы меню
		// все зациклено а потому погрузимся вовнутрь
		while (true) {
			// теперь программа стала компактнее и не обязательно больше держать эти отступы, они не нужны
			askCategory();
			int categoryIndex = selectMenu(); // автоматический рефакторинг лучше ручного. меньше вероятности сделать ошибку.
			Category category = chooseCategory(categoryIndex); 
			printProjects(category);
			// мне нравится. Запущу, потещу ручками и закоммичу этот подготовительный рефакторинг
			
			// конец цикла, возвращаемся вначало где снова спросим пользователя выбрать категорию
			// вот тут то нам и надо разрабатывать дальше. 
			// теперь можно дополнять код в местах, где я написал 
			// идея в том, что вы вначале написали программу на русском языке, в комментариях
			// увидели ее структуру и теперь можно спуститься глубже и начать прорабатывать детали
			// поехали? 
			
//			while (true) { // этот цикл пока пустой я его закомментирую
				// попросить пользователя выбрать проект по номеру
				// где-то "попросить пользователя" у нас уже было наверху, правда? Мы просили категорию.
				// есть два подхода - copy past - чем мы породим дублирование, его не рекомендую.
				// и extract method - это больше по ООП. 
				
				// найти проект по индексу
				// тут потом будет код TODO 
				
				// распечатать подробности проекта, включающие в себя 
				// + все то же что в списке - это уже есть
				// + история проекта - тут надо будет добавить TODO
				// + линк на видео с демо - тут надо будет добавить TODO
				// + вопросы/ответы - тут надо будет добавить TODO
				
				// ну и пока не перешли к следующей категории можно предложить пользователю снова выбрать другой проект,
				// то есть надо зациклить вот так
				// да цикл бесконечный, потому мы тут поставим TODO и разберемся что делать дальше (это уже следующая история)
//			}
		}
	}

	private void printProjects(Category category) {
		// получаю список проектов
		// вывожу информацию про каждый проект по очереди
		Project[] foundProjects = projects.getProjects(category);
		for (Project project : foundProjects) {
			printProject(project); 				
		}
	}

	private void printProject(Project project) {
		// тело цикла обычно так же стоит выделить, что тут делается? печатается меню проектов
		System.out.println(project.getName());
		System.out.println(project.getDescription()); 
		System.out.println("Уже собрали " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
		System.out.println("Надо собрать " + project.getExist() + " грн");
		System.out.println("--------------------------------------");
	}

	private void askCategory() {
		// предлагаем выбрать категорию
		System.out.println();
		System.out.println("Выберите категорию:");
		System.out.println(Arrays.toString(categories.getCategories()));
	}

	private Category chooseCategory(int categoryIndex) {
		// получаю выбранную категорию <- но я бы повыделял все это в отдельные методы по аналогии - так будет лучше
		Category category = categories.getName(categoryIndex);
		System.out.println("Вы выбрали категорию: " + category.getName());
		System.out.println("--------------------------------------");
		return category;
	}

	// он выделил private внутренний метод. класс! теперь мы можем его повторно использовать. 
	private int selectMenu() {
		// спрашиваем пользователя что он хочет выбрать <- вот он!
		// этот заголовок намекает на название будущего метода
		Scanner scanner = new Scanner(System.in);
		int categoryIndex = scanner.nextInt();
		// обрати внимание, что каждый блок кода отделен пробелами и у некоторых даже может быть коммент
		// это значит одно - автор сделал специально так, потому что эти две строки друг без друга не имеют смысла
		// а значит так, надо выделить их в метод отдельный. Это можно было сделать сразу, но я специально подождал
		// пока строки мне не понадобятся. Вот этот отступ указывает границы будущшего метода, а 
		return categoryIndex;
	}
}
