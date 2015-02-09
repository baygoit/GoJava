package goit.iavorskyi;

import java.util.LinkedList;
import java.util.List;

public class LearningUnit {

	private String author = "";
	private List<Comment> comments = new LinkedList<Comment>();
	private Rating rating = new Rating();
	private boolean isApproved = false;
	private boolean isDeclined = false;

	public boolean approve() {
		if (!isApproved) {
			isApproved = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean decline() {
		if (!isDeclined) {
			isDeclined = true;
			return true;
		} else {
			return false;
		}
	}
	
	public int calculatePopularity() {
		return rating.getMarks().size() + comments.size();
	}
	
	public List<Comment> getComments() {
		return comments;
	}
		
	public Rating getRating() {
		return rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
			
}
