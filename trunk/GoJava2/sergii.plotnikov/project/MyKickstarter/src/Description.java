
public class Description {
	private String title;
	private String shortDescr;
	private String projectStory;
	private String link;
	
	public void initTitle(String title){this.title=title;}

	public String getTitle() {return title;}
	
	public String getShortDescr() {	return shortDescr;}
		
	public String getProjectStory() { return projectStory;}
	
	public String getLink() { return link;}
	
	public Description(){
		shortDescr = "this is a short description";
		projectStory = "this is a very interesting project story";
		link = "www.link.com";
	}
}
