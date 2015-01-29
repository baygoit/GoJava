package goit.iavorskyi.units;

import java.util.LinkedList;
import java.util.List;

public class LearningUnit {
	
	private int likes = 0;
	private List <String> comments = new LinkedList();
	private String name = "";
	private String source = "";
	
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public List<String> getComments() {
		return comments;
	}
	public void addComment(String comment) {
		this.comments.add(comment);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public boolean createNew() {
		return true;
	}
	
	public int calculateValue() {
		return 0;
	}
	
	

}
