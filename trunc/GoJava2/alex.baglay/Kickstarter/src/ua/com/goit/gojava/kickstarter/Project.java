package ua.com.goit.gojava.kickstarter;

public class Project {

	private String name;
	private int amount;
	private int days;
	private Category category;
	private String description;
	private int exist;
	private String history;
	private String demoVideo;
	private String questionAnswers;

	public Project(String name, int amount, int days, String demoVideo, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
		this.demoVideo = demoVideo; 
		this.history = null;
		this.questionAnswers = null;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setHistory(String history) {
		this.history = history;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAmount() {
		return amount;
	}

	public int getExist() {
		return exist;
	}

	public int getDays() {
		return days;
	}
	
	public void setDemoVideo(String demoVideo) {
		this.demoVideo = demoVideo;
	}
	
	public void setQuestionAnswers(String questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public String getHistory() {
		// так, интересно, что хочет заказчик говоря - хистори? :)
		// наверное историю проплат, ответов на вопросы - такая себе лента событий. Ну да ладно, сейчас это 
		// ничем не отличается от дескрипшена, единственное что это необязательно для проекта поле - его можно заполнять потом
		// А потому не будем передать его через конструктор, а сделаем сеттер, или даже нет - сделаем ленту новостей, 
		// добавим addNews... Или пока рано. В итории жеж не написано ничего? нет
		// часто случается так, что я как дивелопер хочу придумки свои реализовать в проекте заказчика. А ему может быть этого 
		// не надо было. Тогда что? KISS Keep It Simple Stupid. Делай это как можно проще, тупица :) Значит аналог description
		// только через сеттер, так как не композиция.
		return history;
	}

	public String getDemoVideo() {
		// Наверное тут надо сделать тоже через сеттер, или через конструктор? 
		// это необходимое свойство или опциональное? Надо спрашиватть заказчика :) 
		return demoVideo;
	}

	public String getQuestionAnswers() {
		// тут надо понять как работать с вопросами и ответами, но пока ничего конкретно не указано то KISS
		// пусть это будет поле, которое как и history будет меняться по ходу выполнения программы, как бы такое себе FAQ
		return questionAnswers;
	}

}
