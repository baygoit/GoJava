package ua.com.goit.gojava7.kickstarter.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoTest {

    @Mock
    private MyValidator myValidator;
    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private QuestionDao questionDao;

    @Test
    @Ignore
    public void testCreateQuestion() {
        when(myValidator.validateQuestion(anyObject())).thenReturn(false);

        //questionDao.createQuestion("new question", 1L);

        verify(myValidator).validateQuestion(anyObject());
    }
}
