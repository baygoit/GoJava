package ua.kutsenko.KickstarterGoIt.domain;

public class Quote {
	private int id;
	private String text;
	private String author;
	

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}
	public Quote(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getQuote(Quote quote){
		StringBuilder sb = new StringBuilder();
		sb.append(quote.getText());
		sb.append(" . " + quote.getAuthor());
		String result = sb.toString();
		return result;
		
	}
	

}
