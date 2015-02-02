package ua.com.goit.gojava.kickstarter;

public class KickstarterRunner {

	// теперь наша задача протестировать то, что мы написали. 
	// это делается с одной целью - чем дальше в лес тем больше фичей нам надо будет реализовать
	// и реализовывая что-то одно можно поломать что-то другое. А так как мы все время проверять все не сможем, то вполне возможно 
	// упустим багу в production что недопустимо. нам нужна армия роботов, которая будет делать за нас всю глязную работу. 
	// создадим для них площадку. папка (source folter) test с той же структурой пакетов. 
	// начнем тестировать самвые мелкие классы, которые ни от чего не зависят. Потом возьмемся за кискстартер. 
	// знаешь зачем мы делаем тот же самый пакет? А чтобы тесты думали что они находятся там же где и основные классы,  - так мы 
	// сможем дергать за package защищенные поля и ментоды. Такая себе уловочка. Но физически классы тестов размещены в отдельной папке, что 
	// значит мы их в production при сборке приложения в будущем просто не пустим
	
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
		
		//	сценарий 2: находясь в описании проекта -> вижу меню "0 - выход" -> выбираю 0 -> 
		//		попадаю в меню проектов -> вижу список проектов и возможность выбора другого проекта */
		// А второй сценарий у меня как бы и сам получается реализован, у меня нет пока никакого меню внутренностей проекта :) Чем не KISS?
		// может заказчику так он, спросить надобно TODO. 
	}

}
