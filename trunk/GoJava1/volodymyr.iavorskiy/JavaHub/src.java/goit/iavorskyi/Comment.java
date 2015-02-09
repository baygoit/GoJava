package goit.iavorskyi;

public class Comment {

	private String author = "";
	private String comment = "";
	
	public void addComment(String comment, String author) {
		this.comment = comment;
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public String getAuthor() {
		return author;
	}

}
