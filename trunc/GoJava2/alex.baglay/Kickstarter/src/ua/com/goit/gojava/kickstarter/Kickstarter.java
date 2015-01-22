package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	// сохранили как поле, проекты это штука важная ее надо сохранить как поле класса. Мы ими будем пользоваться регулярно
	private Projects projects; 

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public static void main(String[] arguments) {		
		Category category1 = new Category("Photo");
		Category category2 = new Category("Video");
		Category category3 = new Category("Music");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		// смотрим следующую историю
		// Как гость я хочу изучить список проектов определенной категории, чтобы понять во что я хочу инвестировать
		// Сценарий: захожу в приложение -> выбираю любую категорию (1 - спорт) -> вижу список проектов, каждый из которых содержит:
	    //      название, краткое описание, сумму необходиму для сбора, сколько собрали уже, сколько дней осталось
		
		// если разобраться, тут вводится новое понятие СписокПроектов состоящее из Проектов. 
		// Проект (как композит состоит из свойств): название (String), Сумма для сбора (int), Сколько собрали (int), 
		// Сколько дней осталось (int). Создадим его? 
		// вот наша песочница
		
		// я вот тут начал было тулить через конструктор параметр "сколько собрали" и понимаю, что эта цифра изначально всегда = 0
		// и потому через конструктор ее передавать не стоит - это свойство можно внутри проинициализировать, оно имеет смысл после 
		// создания проекта, а не до

		Project project1 = new Project("Фильм \"Как кодить на java\"", 100000, 15, 
				"Фильм о том, как можно самому научиться кодить на Java");
		
		Project project2 = new Project("Фильм \"GoJava\"", 2345, 10, 
				"Фильм о том, как ребята учатся Java с GoIT");

		// тут возникает вопрос, а как у нас проекты связаны с категориями? 
		// наверное категория - это свойство проекта, и надо нам об этом позаботиться заблаговременно
		// допустим я не решил сразу в какую категорию мне поставить проект, потому я отложу это на потом - поможет setter
		project1.setCategory(category2);
		project2.setCategory(category2); // ошибся :)
		// у нас все фильмы
		
		// Вот у нас есть два проекта. По аналогии как делали с категориями нам теперь надо список
		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		
		// и потом эти проекты должны как-то появиться в нашем кикстартере. Сделаем по аналогии с категориями
		// но нам надо чтобы проекты выводились на экран, и это уже ответственность класса Kickstarter 
		Kickstarter application = new Kickstarter(categories, projects);
		
		application.run();
	}


	private void run() {		
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
		
		while (true) {
			System.out.println();
			System.out.println("Выберите категорию:");
			System.out.println(Arrays.toString(categories.getCategories()));
			
			Scanner scanner = new Scanner(System.in);
			int categoryIndex = scanner.nextInt();
	
			Category category = categories.getName(categoryIndex);
			System.out.println("Вы выбрали категорию: " + category.getName());
			
			// идем дальше. мы выбрали категорию и по истории нам сказано, что надо вывести все проекты этой категории. 
			// Но у нас все проекты содержатся в одном хранилище projects и у каждого проекта будет стоять какая-то своя категория
			// какой объект должен быть ответственный за поиск проекта по категориям? Наверное projects
			
			System.out.println("--------------------------------------"); 
			// у нас есть имя, а нам надо категорию. Может из метода categories.getName(categoryIndex)
			// стоит возвращать не имя а весь объект? попробуем
			Project[] foundProjects = projects.getProjects(category);
			
			// а нет :) теперь надо вывести на экран
			for (Project project : foundProjects) {
				// выведем все поля
				// название, краткое описание, сумму необходиму для сбора, сколько собрали уже, сколько дней осталось
				System.out.println(project.getName());
				System.out.println(project.getDescription()); // ах да, совсем забыли! готово! мы всегда можем подправить что хотели
				// тут надо дополнительное инфо, а то выглядит ужасно
				System.out.println("Надо собрать " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
				System.out.println("Уже собрано " + project.getExist() + " грн");
				System.out.println("--------------------------------------"); 
				// ну что посмотрим? // мне нравится, за исключением одной штуки-  программа сразу же выходит после отображения списка. Надо бы 
				// ее зациклить
			}
		}
		// с зацикливанием есть вопросы, но пока этого достаточно. Можно уже что-то показать пользователям... commit
	}
}
