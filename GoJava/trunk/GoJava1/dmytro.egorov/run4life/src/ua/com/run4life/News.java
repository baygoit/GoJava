package ua.com.run4life;

import java.util.ArrayList;
import java.util.List;

public class News {
	private List<Article> articles = new ArrayList<Article>();
	private List<Event> events = new ArrayList<Event>();
	
	public void addNews(Article article){
		this.articles.add(article);
	}

	public List<Article> getArticle() {
		return articles;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void addEvents(Event event) {
		this.events.add(event);
	}

}
