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
			// TODO нет нумерации проектов - это где-то тут должно быть
			printProjects(category);
			// мне нравится. Запущу, потещу ручками и закоммичу этот подготовительный рефакторинг
			
			// конец цикла, возвращаемся вначало где снова спросим пользователя выбрать категорию
			// вот тут то нам и надо разрабатывать дальше. 
			// теперь можно дополнять код в местах, где я написал 
			// идея в том, что вы вначале написали программу на русском языке, в комментариях
			// увидели ее структуру и теперь можно спуститься глубже и начать прорабатывать детали
			// поехали? 
			
			// Всегда надо помнить на чем мы остановились, а потому очень рекомендую завести листик A4 и ручку, чтобы записывать
			// В голове это все держать не практично. у дивелопера должны быть навык переключения с стратегии на тактику и наоборот
			// делать это стоит между задачами. Иногда дробление будет несколькоуровневное и надо помнить какую большую задачу решаю, 
			// какую ее подзадачу, и какую ее под-под-задачу, а так же что уже попробовал и что еще осталось. Держать это все в голове сложно
			// потому список задач A4 - ваш лучший друг
			
			while (true) { // этот цикл пока пустой я его закомментирую
				// попросить пользователя выбрать проект по номеру
				// где-то "попросить пользователя" у нас уже было наверху, правда? Мы просили категорию.
				// есть два подхода - copy past - чем мы породим дублирование, его не рекомендую.
				// и extract method - это больше по ООП. 
				// где наш метод?
				
				// предложение выбрать фильм
				askProject();
	
				int projectIndex = selectMenu(); 
				// найти проект по индексу
				Project project = chooseProject(projectIndex); // тут по аналогии :)
									
				printProjectDetails(project);
				
				// ну и пока не перешли к следующей категории можно предложить пользователю снова выбрать другой проект,
				// то есть надо зациклить вот так
				// да цикл бесконечный, потому мы тут поставим TODO и разберемся что делать дальше (это уже следующая история)
			}
			
			// вот мой А4 для задачек. Оставляю тут, чтобы знать что еще надо сделоать. Беру самую простую задачу. 
			// TODO форматирование страдает :)
		}
	}

	private void askProject() {
		// по аналогии
		// предлагаем выбрать проект
		System.out.println();
		System.out.println("Выберите проект");
	}

	private void printProjectDetails(Project project) {
		// распечатать подробности проекта, включающие в себя 
		// + все то же что в списке - это уже есть и надо повторно использовать
		printProject(project);
		// + история проекта 
		System.out.println(project.getHistory()); // новое понятие
		// + линк на видео с демо  
		System.out.println(project.getDemoVideo()); // новое понятие
		// + вопросы/ответы  
		System.out.println(project.getQuestionAnswers()); // новое понятие
	}

	// Метод реализован, сделаем его по аналогии c категорией 
	private Project chooseProject(int projectIndex) {
		Project project = projects.get(projectIndex);
		System.out.println("Вы выбрали проект: " + project.getName());
		System.out.println("--------------------------------------");
		return project;
	}

	private void printProjects(Category category) {
		// получаю список проектов
		// вывожу информацию про каждый проект по очереди
		Project[] foundProjects = projects.getProjects(category);
		for (int index = 0; index < foundProjects.length; index++) {
			Project project = foundProjects[index];
			System.out.print(index + " - "); // тут заметь print без ln
// я много накодил и хочу сохраниться
			printProject(project); 				
			// тут у нас индекса нет, а потому надо его как-то родить. 
			// параллельно я помню, что проекты у меня все со всех категорий хранятся в одном хранилище, и их 
			// нумерация не совпадает с нумерацией в меню
			// сейчас покажу. Я зайду в категорию в корой нет проектов и выберу 1 и увижу проект из другой 
			// категории... это бага 
			// TODO и еще одна ошибка, я в другой категории могу выбрать проект из другой категории
			// наверное надо придумать как-то как мы буем различать проекты - это одно число
			// а меню строится по другому числу
			// но пока хоть выведу тут индекс
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
		Category category = categories.get(categoryIndex);
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
