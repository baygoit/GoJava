package goit.iavorskyi.domain;

public class Rating {

	private String author;
	private int rating;
	
	public Rating() {
		
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
