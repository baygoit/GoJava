package ua.com.goit.gojava.kickstarter;

public class Project {

	private String name;
	private int amount;
	private int days;
	private Category category;
	private String description;
	private int exist;

	public Project(String name, int amount, int days, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		return "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt "
				+ "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco l"
				+ "aboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in "
				+ "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat "
				+ "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
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
