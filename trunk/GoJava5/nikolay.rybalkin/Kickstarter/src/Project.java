
public class Project {

	private String name;
	private String description;
	private int amount;
	private int exist;
	private int days;



	private Category category;
	private String history;
	private String video;
	private String faq;


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

	public void setHistory(String history) {
		this.history = history;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public void setFaq(String faq) {
		this.faq = faq;
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
		return history;
	}

	public String getVideo() {
		//TODO забито хардкодом
		return video;
	}

	public String getFAQ() {
		//TODO забито хардкодом
		return faq;
	}
}
