package ua.com.goit.gojava7.kickstarter.dao.db;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-db.xml",
"classpath:applicationContext.xml"})
@Transactional
public class QuestionDatabaseDaoIntegrationTest{
    @Autowired
    private QuestionDatabaseDao questionDao;
    @Test
    public void testGetQuestionsByProjectId() {
        assertThat(questionDao.getQuestionsByProjectId(1) != null, is(true));
    }

}
