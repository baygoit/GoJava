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
	// DONE меню конкретного проекта - этого у меня еще нету. Сейчас проверим. Да сейчас выбирая проект я могу посмотреть его описание 
	// и сразу же выбрать следуюший. Выберите проект: [1...2] или 0 для выхода . Можно сделать для начала так, чтобы у проекта было свое 
	// меню с одним единственным пунктом - выход.
	// TODO дальше можно добавить еще один пункт. Оплата, захоя в который программа запросит 
	// последовательно имя, номер карточки и сумму, а после ввода возвращаться обратно в меню проекта
	// TODO дальше можно сделать чтобы сумма списывалась из проекта как оплаченная. И на этом вроде как все. 
	// Пока мне видятся такие етапы.
	public void run() {		
		println(generator.nextQuote());
		
		categoryMenu().run();
		println("Спасибо за использование нашей программы!");
	}

	// это у нас меню категорий.
	private Menu categoryMenu() {
		// создаем меню категорий, передаем в него нашего io для работы с вводом выводом 
		return new Menu(io) {
			// этот метод вызовется тогда когда мы выберем какой-то пункт меню (не 0)
			@Override
			// на вход приейдет выбранный объект
			Menu nextMenu(Object selected) {
				// мы знаем что это категория потому переопределим его
				Category category = (Category)selected;
								
				// сделаем то что должны
				Project[] found = projects.getProjects(category); // печатаем детали по выбору
				printProjects(found);	
				
				// и покажем меню проектов категории
				return projectsMenu(found); 
			}

			// А этот метод у нас вызовется сразу после того как пользователь введет циферку
			@Override
			Object choose(int menu) {
				// тут мы выбираем категорию
				return chooseCategory(menu); // выбираем
			}

			@Override
			// А этот пункт меню вызовется, когда мы тольтко только зайдем в меню в самом начале
			void ask() {
				askCategories();  // просим выбрать что-то
			}
		};
	}

	// это меню проекты
	// так же и тут
	private Menu projectsMenu(final Project[] found) {
		// создаем меню и передаем ему ввод-вывод
		return new Menu(io) {
			// вызовется, когда мы выберем что-то в этом меню
			@Override
			Menu nextMenu(Object selected) {
				// Мы точно знаем что тут будет проект
				Project project = (Project)selected;
				
				chooseProject(project); // печатаем детали по выбору 													
				printProjectDetails(project);
				// возвращаем конкретное меню проекта
				return projectMenu(project); 
			}

			// тут делаем выбор
			@Override
			Object choose(int menu) {
				return chooseProject(menu, found); // иначе выбираем
			}

			// тут печатаем заголовок меню
			@Override
			void ask() {
				askProjects(found); // просим выбрать что-то
			}
		};
	}
	// это все общий алгоритм работы меню, и он уже требует чтобы его выделили, потому как уже в третий раз прийдется его дублировать
	// вопрос в том, как это сделать так, чтобы при этом в кикстартере осталась конкретика что делается в каждом меню, а 
	// в класс Меню ушла абстрактная часть. Разберемся позже TODO. А сейчас пока что сделаем копипастом 
    // Я бы сейчас занялся выносом логики меню. Хороший такой себе реакториг получится!
	
	// пока это все у нас какого-то такого себе процедурного стиля и чем дальше в лес, 
	// тем больше в Кикстартере ответственности за логику работы программы вместе с логикой хождения по меню. 
	// думаю вскоре надо будет выделить класс Меню из Кикстартаера, поскольку я уже вижу его внутренности. 
	// посмотри сам(а)
	// и так же тут
	private Menu projectMenu(final Project project) {
		return new Menu(io) {
			// выбрали меню и обрабатываем его
			@Override
			Menu nextMenu(Object selected) {
				Integer menu = (Integer)selected;
				
				if (menu == 1) {
					println("Спасибо, что хотите помочь проекту!");
				}
				
				return null;  // тут надо обработать null в базовом классе
			}

			// выбираем циферкой
			@Override
			Object choose(int menu) {
				return menu;
			}

			// заголовок меню
			@Override
			void ask() {
				askProject(project); // просим выбрать что-то	
			}
		};
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
