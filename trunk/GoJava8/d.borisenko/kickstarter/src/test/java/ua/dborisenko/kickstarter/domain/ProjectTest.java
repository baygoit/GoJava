package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
public class ProjectTest {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Test
    public void mappingTest() {
        int projectId;
        try (Session session = sessionFactory.openSession()) {
            Category category = new Category();
            Project project = new Project();
            project.setName("testname");
            project.setDescription("testdescription");
            project.setHistory("testhistory");
            project.setVideoUrl("testvideourl");
            project.setRemainingDays(10);
            project.setRequiredSum(100);
            project.setCategory(category);
            session.save(category);
            session.save(project);
            session.flush();
            projectId = project.getId();
        }
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Project WHERE id = :id");
            query.setInteger("id", projectId);
            List<Project> resultList = query.list();
            Project resultProject = resultList.get(0);
            session.flush();
            assertThat(resultProject.getName(), is("testname"));
            assertThat(resultProject.getDescription(), is("testdescription"));
            assertThat(resultProject.getHistory(), is("testhistory"));
            assertThat(resultProject.getVideoUrl(), is("testvideourl"));
            assertThat(resultProject.getRemainingDays(), is(10));
            assertThat(resultProject.getRequiredSum(), is(100));
        }
    }
}
