import com.epic.app.model.Question;
import com.epic.app.model.User;
import com.epic.app.model.UserAnswer;
import com.epic.app.service.QuestionService;
import com.epic.app.service.UserAnswerService;
import com.epic.app.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by Pas8sion on 06.01.2015.
 */
//@Transactional
public class UserAnswerServiceIntegrationTest extends IntegrationTest{


    @Test
    public void CrudTest() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfiguration.class);
        UserAnswerService userAnswerService = (UserAnswerService) context.getBean("userAnswerServiceImpl");
        QuestionService questionService = (QuestionService) context.getBean("questionServiceImpl");
        UserService userService = (UserService) context.getBean("userServiceImpl");

        UserAnswer userAnswer = new UserAnswer();

       /* User user = new User();
        user.setLogin("test login");
        user.setPassword("test password");*/

        User user = userService.getUser("test login");

        /*Question question = new Question();
        question.setNumber("12345");
        question.setContent("12345 тестовый вопрос");
        question.setOpenQuestion(false);*/

        Question question = questionService.getQuestion("5");

       /* Answer a = new Answer();
        a.setNumber("111");
        a.setContent("111 тест контент");
        a.setCorrectAnswer(false);
        a.setQuestionOwner(question);*/

        userAnswer.setTestingDate(new Date());
        userAnswer.setUser(user);
        userAnswer.setAnswer(question.getAnswers().get(0));
        userAnswer.setQuestion(question);
        userAnswer.setUserAnswerYesNo(Boolean.TRUE);

        userAnswerService.add(userAnswer);



        //User user = userService.("test login");

        //assertEquals(question.getId(), questionDB.getId());
        //assertEquals(question.getContent(), questionDB.getContent());
        //ReflectionAssert.assertReflectionEquals(question, questionDB);

        //userService.remove(user);
       //questionDB = questionService.getQuestion("12345");
       //assertEquals(null, questionDB);


    }
}
