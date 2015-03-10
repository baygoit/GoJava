package ua.com.goit.gojava.kickstarter.data;

import java.io.Serializable;

public class Parameters implements Serializable {
	private String history;
	private Link demo;
	private Link faq;

	public Parameters(String history, String demo, String faq) {
		this.demo = new Link(demo);
		this.faq = new Link(faq);
		this.history = history;
	}

	public String getHisory() {
		return history;
	}

	public String getDemoLink() {
		return demo.getUrl();
	}

	public String getFaqLink() {
		return faq.getUrl();
	}
}
