package ua.com.run4life;

import java.util.ArrayList;
import java.util.List;

public class News {
	private List<Articles> articles = new ArrayList<Articles>();
	private List<Events> events = new ArrayList<Events>();
	
	public void addNews(Articles article){
		this.articles.add(article);
	}

	public List<Articles> getArticle() {
		return articles;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void addEvents(Events event) {
		this.events.add(event);
	}

}
