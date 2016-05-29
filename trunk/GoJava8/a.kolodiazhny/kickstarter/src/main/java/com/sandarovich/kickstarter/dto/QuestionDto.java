package com.sandarovich.kickstarter.dto;


public class QuestionDto {

    private String text;
    private long projectId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
