package com.vladik.model;

public class Faq {
    private int projectID;
    private String question;
    private String answer;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "projectID=" + projectID +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
