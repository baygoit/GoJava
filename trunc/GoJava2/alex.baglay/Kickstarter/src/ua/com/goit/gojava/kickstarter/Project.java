package ua.com.goit.gojava.kickstarter;

public class Project {

	private String name;
	private int amount;
	private int days;
	private Category category;
	private String description;
	private int exist;
	private String history;

	public Project(String name, int amount, int days, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
		this.history = null;
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

	public String getHistory() {
		// пока я захардкоджу тут какое-то бла бла бла, чтобы просмотреть как оно работает впринципе
		// текст рыба, обычно его используют для заполнения контента
		// недоделано потому ставлю TODO
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
		// недоделано потому ставлю TODO
		return "http://youtube.com/tg67f347fg";
	}

	public String getQuestionAnswers() {
		// недоделано потому ставлю TODO
		return "Q: вопрос \n" +  // \n мисвол переноса строки
	           "A: ответ";
	}

}
