package ua.com.goit.gojava7.kickstarter.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.config.Validator;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoTest {

    @Mock
    private Validator validator;
    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private QuestionDao questionDao;

    @Test
    public void testCreateQuestion() {
        when(validator.validateQuestion(anyObject())).thenReturn(false);

        questionDao.createQuestion("new question", 1L);

        verify(validator).validateQuestion(anyObject());
    }

    @Test
    public void testCreateQuestion2() {
        when(validator.validateQuestion(anyObject())).thenReturn(true);


        questionDao.createQuestion("new question", 1L);

        verify(validator).validateQuestion(anyObject());
        verify(projectDao).get(anyLong());

    }
}
