package gojava.InMemory;

import gojava.Interface.Description;

public class InMemoryDescription implements Description{
	private String title;
	private String shortDescr;
	private String projectStory;
	private String link;
	
	public InMemoryDescription(String title){
		this.title=title;
		shortDescr = "this is a short description";
		projectStory = "this is a very interesting project story";
		link = "www.link.com";
	}
	
	@Override
	public String getTitle() {return title;}
	
	@Override
	public String getShortDescr() {	return shortDescr;}
		
	@Override
	public String getProjectStory() { return projectStory;}
	
	@Override
	public String getLink() { return link;}

}
