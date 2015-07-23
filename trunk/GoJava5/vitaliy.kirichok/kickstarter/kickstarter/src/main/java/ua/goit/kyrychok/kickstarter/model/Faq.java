package ua.goit.kyrychok.kickstarter.model;

public class Faq {
    private String question;
    private String answer;
    private int id;

    public Faq(String question) {
        this.question = question;
    }

    public Faq(String question, String answer) {
        this(question);
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
