import com.epic.app.model.User;
import com.epic.app.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pas8sion on 06.01.2015.
 */
@Transactional
public class UserServiceIntegrationTest extends IntegrationTest{


    @Test
    public void CrudTest() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfiguration.class);
        UserService userService = (UserService) context.getBean("userServiceImpl");

        User user = new User();
        user.setLogin("test login");
        user.setPassword("test password");
        userService.add(user);



        //User user = userService.("test login");

        //assertEquals(question.getId(), questionDB.getId());
        //assertEquals(question.getContent(), questionDB.getContent());
        //ReflectionAssert.assertReflectionEquals(question, questionDB);

        userService.remove(user);


       //questionDB = questionService.getQuestion("12345");
       //assertEquals(null, questionDB);


    }
}
