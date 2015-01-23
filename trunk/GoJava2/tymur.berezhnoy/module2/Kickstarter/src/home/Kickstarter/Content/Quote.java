package home.Kickstarter.Content;
public class Quote {
	
	private final char copyrightSymbol = 169;
	private String content;
	private String author;
	
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public String getContent() {
		return content;
	}
	
	public String getOwner() {
		return new String(" " + copyrightSymbol + " " + author);
	}
}