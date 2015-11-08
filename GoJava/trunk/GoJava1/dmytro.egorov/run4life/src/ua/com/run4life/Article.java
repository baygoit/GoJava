package ua.com.run4life;

import java.util.Date;

public class Article {
	private String name;
	private Date date;
	private String content;
	
	public Article(String name, Date date, String description){
		this.name = name;
		this.date = date;
		this.content = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return content;
	}
	
	public void setDescription(String description) {
		this.content = description;
	}
}
