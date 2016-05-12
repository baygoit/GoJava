package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProjectTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        int projectId;
        Category category = new Category();
        Project project = new Project();
        project.setName("testname");
        project.setDescription("testdescription");
        project.setHistory("testhistory");
        project.setVideoUrl("testvideourl");
        project.setRemainingDays(10);
        project.setRequiredSum(100);
        project.setCategory(category);
        em.persist(category);
        em.persist(project);
        projectId = project.getId();
        Query query = em.createQuery("FROM Project WHERE id = :id");
        query.setParameter("id", projectId);
        Project resultProject = (Project) query.getSingleResult();
        assertThat(resultProject.getName(), is("testname"));
        assertThat(resultProject.getDescription(), is("testdescription"));
        assertThat(resultProject.getHistory(), is("testhistory"));
        assertThat(resultProject.getVideoUrl(), is("testvideourl"));
        assertThat(resultProject.getRemainingDays(), is(10));
        assertThat(resultProject.getRequiredSum(), is(100));
    }
}
