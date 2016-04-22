package ua.dborisenko.kickstarter.domain;

public class Question implements Comparable<Question> {

    private int id;
    private Project project;
    private String request;
    private String reply;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int compareTo(Question question) {
        return this.id - question.getId();
    }
}
