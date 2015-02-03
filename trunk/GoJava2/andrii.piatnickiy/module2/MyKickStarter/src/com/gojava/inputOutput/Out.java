package com.gojava.inputOutput;

import com.gojava.projects.Category;
import com.gojava.projects.ICategory;
import com.gojava.projects.IProject;

public class Out {
    public String output(String in) {
        return in;
    }

    public String output(String string, String string2) {
        return string + string2;
    }

    public String output(String string, int i) {
        return string + Integer.toString(i);
    }

    public String output(int i, String string) {
        return i + string;
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printSb(Object object) {
        System.out.println(object);
    }

    public String printProjectPreview(IProject project) {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Name: ").append(project.getName()).append("\n");
        sb.append("Description: ").append(project.getDescription())
                .append("\n");
        sb.append("Need Sum: ").append(project.getNeedSum()).append("\n");
        sb.append("Current Sum: ").append(project.getCurrentSum()).append("\n");
        sb.append("Days Left: ").append(project.getDaysLeft()).append("\n");
        return sb.toString();

    }

    public String printAdditionalProjectFields(IProject project) {
        StringBuffer sb = new StringBuffer();
        sb.append("ProjectHistory: ").append(project.getProjectHistory())
                .append("\n");
        sb.append("LinkOnvideo: ").append(project.getLinkOnvideo())
                .append("\n");
        sb.append("Questions and answers: ")
                .append(project.getQuestionsAndAnswers()).append("\n");
        return sb.toString();
    }

    public String printCategory(ICategory category) {
        StringBuffer sb = new StringBuffer();
        sb.append(category.toString());
        return sb.toString();
    }


}
