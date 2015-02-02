package ua.com.goit.gojava.kickstarter;

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
		
		Kickstarter application = new Kickstarter(categories, projects);
		
		project1.setHistory("История этого проекта корнями уходит в ....");
		project2.setHistory("Мы только начали и потому особо нечего рассказывать.\n"
				+ "Продолжение следует!");
		
		project1.setQuestionAnswers("Q: какая продолжительность фильма?\n"
				+ "А: два часа");
		
		application.run();
		
		// следующая история - 
		/* Как гость я хочу иметь возможность изучать разные проекты в различных категориях
			сценарий 1: находясь в списке проектов -> вижу запрос на выбор проекта и пункт меню 
				"0 - выход" -> выбираю 0 -> попадаю в меню категорий -> вижу список категорий и возможность выбора другой категории
			сценарий 2: находясь в описании проекта -> вижу меню "0 - выход" -> выбираю 0 -> 
				попадаю в меню проектов -> вижу список проектов и возможность выбора другого проекта */
		// но пока я зачищу все комменты старые...
	}

}
