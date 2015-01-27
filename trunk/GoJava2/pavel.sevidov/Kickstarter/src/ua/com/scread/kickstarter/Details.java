package ua.com.scread.kickstarter;

public class Details {
	private String history;
	private String video;
	private FAQ faq;

	public Details(String history, String video, FAQ faq) {
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
	
	public FAQ getFAQ() {
		return faq;
	}

}
