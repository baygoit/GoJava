package ua.com.goit.gojava7.salivon.beans;

public class Quote {

    private String text;
    private String autor;

    public Quote(String text, String autor) {
        this.text = text;
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
