package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects;
	private IO io; 
	private QuoteGenerator generator; 

	public Kickstarter(Categories categories, Projects projects, IO io, QuoteGenerator generator) {
		this.categories = categories;
		this.projects = projects;
		this.io = io;  
		this.generator = generator;
	}

	// следующая история, которую надо реализовать - 
	// Как гость я хочу инвестировать в понравившийся мне проект, чтобы поддержать его
	// Сценарий: Находясь в конкретном проекте -> Вижу меню с вариантами, что могу сделать, один из пунктов - проинвестировать в проект ->
	// Выбираю его -> Вижу вопрос от пеймент системы о вводе имени и номера карточки и суммы -> Ввожу их ->
	// Перехожу на описание проекта, где вижу что инфа о количестве пожертвований поменялась
	// опять же будем ее декомпозировать на части потому как все сразу реализовать будет сложно
	// Какие части тут есть?
	// TODO меню конкретного проекта - этого у меня еще нету. Сейчас проверим. Да сейчас выбирая проект я могу посмотреть его описание 
	// и сразу же выбрать следуюший. Выберите проект: [1...2] или 0 для выхода . Можно сделать для начала так, чтобы у проекта было свое 
	// меню с одним единственным пунктом - выход.
	// TODO дальше можно добавить еще один пункт. Оплата, захоя в который программа запросит 
	// последовательно имя, номер карточки и сумму, а после ввода возвращаться обратно в меню проекта
	// TODO дальше можно сделать чтобы сумма списывалась из проекта как оплаченная. И на этом вроде как все. 
	// Пока мне видятся такие етапы.
	public void run() {		
		println(generator.nextQuote());
		
		categoryMenu();
		println("Спасибо за использование нашей программы!");
	}

	// это у нас меню категорий.
	private void categoryMenu() {
		while (true) { // цикл
			askCategories();  // просим выбрать что-то
			int menu = io.read(); // читаем номер меню
			if (menu == 0) {  // если 0 - выходим
				break; 
			}
			
			Category category = chooseCategory(menu); // иначе выбираем
			if (category == null) { // если нет ничего, начинаем с начала 
				continue; 
			}
			
			Project[] found = projects.getProjects(category); // печатаем детали по выбору
			printProjects(found);			
			projectsMenu(found); // переходим в подменю, в котором
		}
	}

	// это меню проекты
	private void projectsMenu(Project[] found) {
		while (true) {  // тот же цикл
			askProjects(found); // просим выбрать что-то

			int menu = io.read(); // читаем номер меню
			if (menu == 0) { // Если ноль то выходим из меню
				break; 
			}
			
			Project project = chooseProject(menu, found); // иначе выбираем
			if (project == null) { // если не то выбрали то в начало
				continue;
			}
			
			chooseProject(project); // печатаем детали по выбору 													
			printProjectDetails(project);
			// ну по аналогии получается что тут добавим
			projectMenu(project); // заходим в подменю
		}
	}
	// это все общий алгоритм работы меню, и он уже требует чтобы его выделили, потому как уже в третий раз прийдется его дублировать
	// вопрос в том, как это сделать так, чтобы при этом в кикстартере осталась конкретика что делается в каждом меню, а 
	// в класс Меню ушла абстрактная часть. Разберемся позже TODO. А сейчас пока что сделаем копипастом 

	// пока это все у нас какого-то такого себе процедурного стиля и чем дальше в лес, 
	// тем больше в Кикстартере ответственности за логику работы программы вместе с логикой хождения по меню. 
	// думаю вскоре надо будет выделить класс Меню из Кикстартаера, поскольку я уже вижу его внутренности. 
	// посмотри сам(а)
	private void projectMenu(Project project) {
		while (true) {  // тот же цикл
			askProject(project); // просим выбрать что-то

			int menu = io.read(); // читаем номер меню
			if (menu == 0) { // Если ноль то выходим из меню
				break; 
			}
			
			// TODO тут логика работы с разными выборами меню
			if (menu == 1) {
				println("Спасибо, что хотите помочь проекту!");
				// как по мне готово! Теперь осталось покрыть это все дело тестами
				// скорее всего старые тесты поломаются, но ничего!
				
			}
		}
	}

	private void askProject(Project project) {
		// а нет, у нас жеж уже нельзя использовать консоль напрямую. Теперь для печати мы пользуемся 
		println("Выберите что хотите сделать с проектом: \n"
				+ "[0 - выйти к списку проектов, 1 - инвестировать в проект]");
	}

	private Project chooseProject(int menu, Project[] found) {
		if (menu <= 0 || found.length < menu) {
			println("Неверный индекс меню " + menu);
			return null;  
		}
		return found[menu - 1];
	}

	private void println(String message) {
		io.print(message + "\n");
	}
	
	private void askProjects(Project[] found) {
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
			io.print((index + 1) + " - ");  
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

	private void askCategories() {
		println("Выберите категорию (или 0 для выхода):");
		println(Arrays.toString(categories.getCategories()));
	}

	private Category chooseCategory(int menu) {
		if (menu <= 0 || categories.size() < menu) {
			println("Неверный индекс меню " + menu);
			return null; // TODO не рекомендуется так делать, потому что потенциальный NPE у клиента 
		}
		
		// TODO тут надо привести либо везде к одному виду, либо разделять - на вьюхе от 1 до N а в моделе от 0 до N-1 
		Category category = categories.get(menu - 1); 
		println("Вы выбрали категорию: " + category.getName());
		println("--------------------------------------");
		return category;
	}
}
