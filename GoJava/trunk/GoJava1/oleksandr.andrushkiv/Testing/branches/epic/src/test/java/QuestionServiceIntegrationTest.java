import com.epic.app.model.Answer;
import com.epic.app.model.Question;
import com.epic.app.service.QuestionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pas8sion on 06.01.2015.
 */
@Transactional
public class QuestionServiceIntegrationTest extends IntegrationTest{


    @Test
    public void CrudTest() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfiguration.class);
        QuestionService questionService = (QuestionService) context.getBean("questionServiceImpl");

        Question question = new Question();
        question.setNumber("12345");
        question.setContent("12345 тестовый вопрос");
        question.setOpenQuestion(false);

        Answer a = new Answer();
        a.setNumber("111");
        a.setContent("111 тест контент");
        a.setCorrectAnswer(false);
        a.setQuestionOwner(question);

        Answer b = new Answer();
        b.setNumber("222");
        b.setContent("222 тест контент");
        b.setCorrectAnswer(false);
        b.setQuestionOwner(question);

        List<Answer> answers = new ArrayList<Answer>();
        answers.add(a);
        answers.add(b);
        question.setAnswers(answers);

        questionService.addQuestion(question);
        Question questionDB = questionService.getQuestion("12345");

        //assertEquals(question.getId(), questionDB.getId());
        //assertEquals(question.getContent(), questionDB.getContent());
        ReflectionAssert.assertReflectionEquals(question, questionDB);

       questionService.removeQuestion(question);
       questionDB = questionService.getQuestion("12345");
       assertEquals(null, questionDB);


    }
}
