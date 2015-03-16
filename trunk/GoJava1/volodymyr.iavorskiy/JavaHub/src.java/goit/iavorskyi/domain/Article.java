package goit.iavorskyi.domain;

public class Article {
	
	private String author;
	private String header;
	private String linkToText;
	private String text;
	
	public String getLinkToText() {
		return linkToText;
	}
	public void setLinkToText(String linkToText) {
		this.linkToText = linkToText;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
