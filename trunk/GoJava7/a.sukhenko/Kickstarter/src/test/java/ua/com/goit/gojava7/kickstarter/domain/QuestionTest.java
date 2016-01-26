package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;

public class QuestionTest{
    Question question = new Question();
    Project project = new Project();
    @Test
    public void testSetAnswer() {
        final String answer = "Answer";
        question.setAnswer(answer);
        assertThat(question.getAnswer().equals(answer), is(true));
    }

    @Test
    public void testSetQuestion() {
        final String q = "Question";
        question.setQuestion(q);
        assertThat(question.getQuestion().equals(q), is(true));
    }

    @Test
    public void testSetProject() {
        question.setProject(project);
        assertThat(question.getProject(), is(project));
    }

    @Test
    public void testSetId() {
        int id = 1234;
        question.setId(id);
        assertThat(question.getId(),is(id));
    }

}
