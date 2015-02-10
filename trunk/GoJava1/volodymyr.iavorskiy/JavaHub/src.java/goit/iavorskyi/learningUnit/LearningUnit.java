package goit.iavorskyi.learningUnit;

import java.util.LinkedList;
import java.util.List;

public class LearningUnit {

	private String author = "";
	private List<Comment> comments = new LinkedList<Comment>();
	private List<Rating> rates = new LinkedList<Rating>();
	private boolean isApproved = false;

	public LearningUnit() {

	}

	public int calculatePopularity() {
		return rates.size() + comments.size();
	}

	public boolean deleteComment(int id) {
		for (Comment comment : comments) {
			if (comment.getId() == id) {
				comments.remove(comment);
				return true;
			}
		}
		return false;
	}

	public boolean deleteRate(String author) {
		for (Rating rate : rates) {
			if (rate.getAuthor().equals(author)) {
				rates.remove(rate);
				return true;
			}
		}
		return false;
	}

	public void deleteAllComments() {
		comments.clear();
	}

	public void deleteAllRates() {
		rates.clear();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<Rating> getRating() {
		return rates;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
