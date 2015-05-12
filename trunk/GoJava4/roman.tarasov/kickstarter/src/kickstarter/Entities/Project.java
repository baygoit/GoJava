package kickstarter.Entities;


public class Project {
	public String name = "null";
	public String description = "null";
	public String shortDescription = "null";
	public String history = "null";
	public int id;
	public int goal;
	public int pledged;
	public int daysToGo;
	public String linkToVideo="null"; 
	public int categoryID;
	public int[] usersID;
	public String[] comment;
	private int commentIndex=0;
	final int INIT_SIZE = 10;

	public Project(String name, Category category) {
		this.name = name;
		this.categoryID=category.id;
		usersID=new int[INIT_SIZE];
		comment=new String[INIT_SIZE];
	}
	public void addComment(int userID, String commentToProject){
		usersID[commentIndex]=userID;
		comment[commentIndex]=commentToProject;
		commentIndex++;
	}
	public int getCommentLength(){
		return commentIndex;
	}
	
}
