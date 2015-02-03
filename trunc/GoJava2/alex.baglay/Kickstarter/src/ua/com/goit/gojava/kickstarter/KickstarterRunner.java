package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class KickstarterRunner {

	public static void main(String[] arguments) {		
		Category category1 = new Category("Photo");
		Category category2 = new Category("Video");
		Category category3 = new Category("Music");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		Project project1 = new Project("Фильм \"Как выучить java\"", 100000, 15, 
				"http://youtube.com/tg67f347fg",
				"Фильм о том, что учить Java очень даже просто и интересно");
		
		Project project2 = new Project("Фильм \"GoJava\"", 2345, 10,
				"http://youtube.com/fh4iy990", 
				"Фильм о том, как проходит тренинг по Java в GoIT");
	
		project1.setCategory(category2);
		project2.setCategory(category2); 
		
		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		
		// я это называю "вынесли за скобки". Теперь Kickstarter Не зависит от ConsoleIO а зависит только от интерфейса IO
		// разве не здорово? Теперь мы можем менять поведение кикстартера не вмешиваясь в его внутренности. Вот так напрмиер
		// при условии что у нас был бы реализован EmailIO мы заставили бы кикстартер слать нам письма, вместо работы через консоль
		// это и называется полиморфизм. Воспользуемся им в тестах, чтобы протестировать кокстартер. 
		// Но перед тем проверим как все работает вручную и закоммитимся 
		Kickstarter application = new Kickstarter(categories, projects, 
				new ConsoleIO(), // вернул назад, а то программа не работает :) юнит-тесты не дают 100% гарантии что все будет работать в связке, они только говорят, что модуля работают отдельно
				new QuoteGenerator(new Random())); 
		
		project1.setHistory("История этого проекта корнями уходит в ....");
		project2.setHistory("Мы только начали и потому особо нечего рассказывать.\n"
				+ "Продолжение следует!");
		
		project1.setQuestionAnswers("Q: какая продолжительность фильма?\n"
				+ "А: два часа");
		
		application.run();
		
		//	сценарий 2: находясь в описании проекта -> вижу меню "0 - выход" -> выбираю 0 -> 
		//		попадаю в меню проектов -> вижу список проектов и возможность выбора другого проекта */
		// А второй сценарий у меня как бы и сам получается реализован, у меня нет пока никакого меню внутренностей проекта :) Чем не KISS?
		// может заказчику так он, спросить надобно TODO. 
	}

}
