package model;

public class Quote {

    private String content;
    private String author;

    public Quote(String content, String author) {
	this.content = content;
	this.author = author;
    }
    
    public String getQuote(){
	return ("\"" + content + "\", " + author);
    };

}