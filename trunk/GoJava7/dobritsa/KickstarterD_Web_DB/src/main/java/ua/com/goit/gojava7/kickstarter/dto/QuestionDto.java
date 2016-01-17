package ua.com.goit.gojava7.kickstarter.dto;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class QuestionDto {

    private Long questionId;
    private String time;
    private String question;
    private String answer;
    private Project project = new Project();

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public void setAnswer(String answear) {
        this.answer = answear;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "QuestionDto [questionId=" + questionId + ", time=" + time
                + ", question=" + question + ", answer=" + answer +  ", projectId=" + project.getProjectId() + "]";
    }
}
