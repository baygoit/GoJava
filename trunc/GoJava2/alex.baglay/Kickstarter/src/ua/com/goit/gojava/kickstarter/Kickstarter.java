package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


// Сейчас самое интересное - как потестить вот это чудо, которое зависит от купы других 
// классов, которые нам тестировать особо не хочется - например ввод и вывод из консоли
// генератор цитат
// для начала займемся выделением из класса логики, которая отвечает за ввод и вывод из консоли
// дело в том, что это нам откровенно мешает. Мы не можем протестировать ввод/вывод в консоль
// кроме того нам этого не надо делать. Нам надо проверить что информация дошла до System.out.print
// и пришла из Scanner. А то что они отработали правильно - нам проверять не надо. Джаву уже оттестили и перетестили 
// 1000000 других программистов. Нам интересно что в нашем кикстартере не так - его и протестируем, но перед тем выделим зависимость
// Эта штука, которую мы проделали с QuoteGenerator и его Random, а так же сейчас будем проделывать с КИкстартером и логикой работы
// с консолью называется Inversion of Control (IoC) и делаем мы это следую принципу - Dependency Inversion Principle (DIP)
// одному из глоавных принципов SOLID OOP. Его суть - пусть все зависит от абстракций (интерфейсы и абстрактные классы), но не от 
// конкретных деталей - вызовы new SomeClass() во внутренностях других классов. Как было у нас с new Random() в QuoteGenerator
// поехали! Сейчас надо сделать шаг 1. - собрать все вызовы System.out.print в отдельный метод. 
public class Kickstarter {

	private Categories categories;
	private Projects projects;
	// Теперь можем тут указать абстрактный тип (интерфейс) заместь класса
	private IO io; 
	private QuoteGenerator generator; 

	// а зависимость передадим в конструктор, но как абстракный тип
	public Kickstarter(Categories categories, Projects projects, IO io, QuoteGenerator generator) {
		this.categories = categories;
		this.projects = projects;
		// но у нас все равно осталась зависимость в классе от внешнего другого класса
		// вот тут в конструкторе мы инстанциируем этот консолль IO для работы. 
		// предлагаю вынести, как мы это делали с QuoteGeterator и Random
		// но перед тем введем новое абстрактное понятие (интерфейс)
		this.io = io; // Все просто, теперь мы прользуемся объектом, типа принтер (название не очень) 
		// а не своими специализированными методами. 
		// Я бы еще подумал над названием. Printer это половина класса. Там еще Reader. Может сделать IO?  
		this.generator = generator;
	}

	public void run() {		
		println(generator.nextQuote());
		
		while (true) {
			askCategory();
			int menu = io.read();
			if (menu == 0) { // по аналогии
				break; 
			}
			
			Category category = chooseCategory(menu);
			if (category == null) {
				continue; 
			}
			
			Project[] found = projects.getProjects(category);
			printProjects(found);			
			projectMenu(found);
		}
		println("Спасибо за использование нашей программы!");
	}

	private void projectMenu(Project[] found) {
		while (true) { 
			askProject(found);

			int menu = io.read(); 
			if (menu == 0) {
				break; 
			}
			
			Project project = chooseProject(menu, found);
			if (project == null) {
				continue;
			}
			
			chooseProject(project); 													
			printProjectDetails(project);
		}
	}

	private Project chooseProject(int menu, Project[] found) {
		if (menu <= 0 || found.length < menu) {
			println("Неверный индекс меню " + menu);
			return null;  
		}
		return found[menu - 1];
	}

	// вот он наш метод, теперь надо заменить на вызов print все, что мы в коде используем напрямую
	private void println(String message) {
		io.print(message + "\n");
	}
	
	private void askProject(Project[] found) {
		if (found.length == 0) {
			println("Проектов в категории нет. Нажмите 0 - для выхода.");
		} else {
			int from = 1;
			int to = found.length;
			println("Выберите проект: [" + from + "..." + to + "] или 0 для выхода" );
		}
	}

	private void printProjectDetails(Project project) {
		printProject(project);
		
		println(project.getHistory()); 
		println(project.getDemoVideo()); 
		
		String questionAnswers = project.getQuestionAnswers();
		if (questionAnswers != null) {  
			println(questionAnswers); 
		}
		println("--------------------------------------"); 
	}

	private void chooseProject(Project project) {
		println("Вы выбрали проект: " + project.getName());
		println("--------------------------------------");
	}

	private void printProjects(Project[] found) {
		for (int index = 0; index < found.length; index++) {
			Project project = found[index];
			io.print((index + 1) + " - "); // тут у нас печать без переноса строки 
			printProject(project); 			
		}
	}

	private void printProject(Project project) {
		println(project.getName());
		println(project.getDescription()); 
		println("Уже собрали " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
		println("Надо собрать " + project.getExist() + " грн");
		println("--------------------------------------");
	}

	private void askCategory() {
		println("Выберите категорию (или 0 для выхода):");
		// для начала тут выводится список
		println(Arrays.toString(categories.getCategories()));
	}

	private Category chooseCategory(int menu) {
		if (menu <= 0 || categories.size() < menu) {
			println("Неверный индекс меню " + menu);
			return null; // не рекомендуется так делать, потому что потенциальный NPE у клиента, но что поделать, пока так - оставим TODO
		}
		
		// тут надо привести либо везде к одному виду, либо разделять - на вьюхе от 1 до N а в моделе от 0 до N-1 TODO подумать наж этим
		Category category = categories.get(menu - 1); 
		println("Вы выбрали категорию: " + category.getName());
		println("--------------------------------------");
		return category;
	}

	// вынесли кнутренний класс в отдельный внешний
}
