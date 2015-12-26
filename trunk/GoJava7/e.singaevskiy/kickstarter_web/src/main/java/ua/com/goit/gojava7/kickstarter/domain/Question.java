package ua.com.goit.gojava7.kickstarter.domain;

public class Question {
	private long id;
    private int projectId;
    private String question;
    private String answer;

    public Question() {
        // default bean constructor
    }

    public Question(int projectId, String question, String answer) {
        this.projectId = projectId;
        this.question = question;
        this.answer = answer;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Question [question=" + question + ", answer=" + answer + ", projectId=" + projectId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + projectId;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        if (answer == null) {
            if (other.answer != null)
                return false;
        } else if (!answer.equals(other.answer))
            return false;
        if (projectId != other.projectId)
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        return true;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
