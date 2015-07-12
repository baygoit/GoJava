
public class Project {

	private String name;
	private String description;
	private int amount;
	private int exist;
	private int days;
	private Category category;



	public Project(String name, int amount, int days, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
	}

	public Project(String name){
		this.name = name;
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
		//TODO забито хардкодом
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et" +
				" dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
				" ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
				" fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
				" deserunt mollit anim id est laborum.";
	}

	public String getVideo() {
		//TODO забито хардкодом
		return "https://www.youtube.com/";
	}

	public String getFAQ() {
		//TODO забито хардкодом
		return "questions \n" +
				"answers";
	}
}
