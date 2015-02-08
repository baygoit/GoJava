package ua.home.kickstarter.content;

public class Project {
	private final char dollarSymbol = 36;
	private String name;
	private int goal;
	private int pledged;
	private int daysLeft;
	private String description;
	private String history;
	private String linksToVideo;
	private String questionAnswers;
	private Category category;

	public Project(String name, String description, int goal, int daysLeft, String linksToVideo) {
		this.name = name;
		this.description = description;
		this.goal = goal;
		this.daysLeft = daysLeft;
		this.history = null;
		this.linksToVideo = linksToVideo;
		this.pledged = 0;
		this.questionAnswers = null;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setQuestionAnswers(String questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getShortInfo() {
		StringBuilder shortInfo = new StringBuilder();
		shortInfo.append(" - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓").append("\nНазвание проекта: ").append(name)
				.append("\nОписание проекта: ").append(description).append("\nНеобходимая сумма: ").append(goal)
				.append(dollarSymbol).append("\nСобранная сумма: ").append(pledged).append(dollarSymbol)
				.append("\nДо окончания сбора средств: ").append(daysLeft).append(" дней");
		return shortInfo.toString();
	}

	public String getFullInfo() {
		StringBuilder fullInfo = new StringBuilder();
		fullInfo.append(getShortInfo()).append("\nИстория проекта: ").append(history)
				.append("\nЛинки на видео с демо: ").append(linksToVideo).append("\nВопросы/ответы: ")
				.append(questionAnswers);
		return fullInfo.toString();
	}

}
