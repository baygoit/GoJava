package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void mappingTest() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Category category = new Category();
        Project project = new Project();
        project.setName("testname");
        project.setDescription("testdescription");
        project.setHistory("testhistory");
        project.setVideoUrl("testvideourl");
        project.setDaysLeft(10);
        project.setRequiredSum(100);
        project.setCategory(category);
        session.save(category);
        session.save(project);
        tx.commit();
        session.flush();
        int projectId = project.getId();
        session.close();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("FROM Project WHERE id = :id");
        query.setInteger("id", projectId);
        List<Project> resultList = query.list();
        Project resultProject = resultList.get(0);
        tx.commit();
        session.flush();
        session.close();
        assertThat(resultProject.getName(), is("testname"));
        assertThat(resultProject.getDescription(), is("testdescription"));
        assertThat(resultProject.getHistory(), is("testhistory"));
        assertThat(resultProject.getVideoUrl(), is("testvideourl"));
        assertThat(resultProject.getDaysLeft(), is(10));
        assertThat(resultProject.getRequiredSum(), is(100));
    }
}
