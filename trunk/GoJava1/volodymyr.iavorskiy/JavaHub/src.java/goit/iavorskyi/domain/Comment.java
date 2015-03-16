package goit.iavorskyi.domain;

public class Comment {

	private String author;
	private String comment;
	private int id;
	
	public Comment() {
		
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}
