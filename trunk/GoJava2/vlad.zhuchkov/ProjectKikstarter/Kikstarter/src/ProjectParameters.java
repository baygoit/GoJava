import java.io.Serializable;

public class ProjectParameters implements Serializable {
	private int cost;
	private int alreadyCollected;
	private int daysLeft;
	private DetailedParameters dParam = new DetailedParameters();

	public void setCost(int cost) {
		this.cost = cost;

	}
	

	public int getDays() {
		return daysLeft;
	}

	public void setAlreadyCollected(int collected) {
		alreadyCollected = collected;

	}

	public int getCost() {
		return cost;
	}

	public int getAlreadyCollected() {
		return alreadyCollected;
	}

	public void addAlreadyCollected(int num) {
		alreadyCollected += num;
	}

	public void setDays(int days) {
		daysLeft = days;

	}

	public class DetailedParameters implements Serializable {
		private String history;
		private Link demo;
		private Link faq;

		private DetailedParameters() {
			history = "\n*history**history**history*\n"
					+ "history**history**history*\n"
					+ "history**history**history*";
			demo = new Link();
			faq = new Link();
		}

		public String getHisory() {
			return history;
		}

		public String getDemoLink() {
			return demo.getUrl();
		}

		public String getFaqLink(){
			return faq.getUrl();
		}
	}

	public DetailedParameters getDetailedParameters() {
		return dParam;
	}

}
