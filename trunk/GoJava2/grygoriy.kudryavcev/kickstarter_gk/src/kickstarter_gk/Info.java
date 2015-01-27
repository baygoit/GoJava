package kickstarter_gk;

public class Info {

	private String history;
	private String video;
	private FAQ faq;
	
	public Info (String history, String video, FAQ faq) {
		this.history = history;
		this.video = video;
		this.faq = faq;
	}
	
	public String getHistory() {
		return history;
		}
	
	public String getVideo() {
		return video;
	}
	
	public FAQ getFAQ () {
		return faq;
	}
	
}
