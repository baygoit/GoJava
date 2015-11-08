package ua.com.run4life;

import java.util.Date;

public class Event {
	private String name;
	private Date date;
	private String content;
	
	public Event(String name, Date date, String description){
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
