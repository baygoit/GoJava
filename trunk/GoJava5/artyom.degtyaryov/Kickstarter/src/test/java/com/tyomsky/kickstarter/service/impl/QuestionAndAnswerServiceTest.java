package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuestionAndAnswerServiceTest {

    @Mock
    QuestionAndAnswerDAO questionAndAnswerDAO;

    @InjectMocks
    QuestionAndAnswerServiceImpl questionAndAnswerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetListByProjects_thenReturnQuestionsAndAnswersList() {
        QuestionAndAnswer questionAndAnswer1 = new QuestionAndAnswer(1, "que1", "answ1");
        QuestionAndAnswer questionAndAnswer2 = new QuestionAndAnswer(2, "que2", "answ2");

        Project project = new Project(1, "name", "description", new Category());
        questionAndAnswer1.setProject(project);
        questionAndAnswer2.setProject(project);

        List<QuestionAndAnswer> expectedQuestionsAndAnswers = Arrays.asList(questionAndAnswer1, questionAndAnswer2);

        when(questionAndAnswerDAO.getListByProject(project)).thenReturn(expectedQuestionsAndAnswers);

        List<QuestionAndAnswer> actualQuestionsAndAnswers = questionAndAnswerService.getListByProject(project);

        verify(questionAndAnswerDAO, times(1)).getListByProject(project);

        assertArrayEquals(expectedQuestionsAndAnswers.toArray(), actualQuestionsAndAnswers.toArray());
    }

    @Test
    public void whenSave_thenSaveToDao() {
        QuestionAndAnswer questionAndAnswer1 = new QuestionAndAnswer(1, "que1", "answ1");
        questionAndAnswer1.setProject(new Project());

        when(questionAndAnswerDAO.save(questionAndAnswer1)).thenReturn(questionAndAnswer1);

        questionAndAnswerService.save(questionAndAnswer1);
        verify(questionAndAnswerDAO, times(1)).save(questionAndAnswer1);
    }

}