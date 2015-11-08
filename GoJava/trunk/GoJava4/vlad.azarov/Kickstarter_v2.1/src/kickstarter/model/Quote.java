package kickstarter.model;

public class Quote {

    private String content;
    private String author;

    public Quote(String content, String author) {
	this.content = content;
	this.author = author;
    }
    
    public String getQuoteContent() {
	return content;
    }
    
    public String getQuoteAuthor() {
	return author;
    }
    
    @Override
	public String toString() {
		return content + ", " + author;
	}

}