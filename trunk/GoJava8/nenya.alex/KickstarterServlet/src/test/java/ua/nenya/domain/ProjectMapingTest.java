package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class ProjectMapingTest {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void testProjectUsage() {
		int id;
		try (Session session = sessionFactory.openSession()) {
			Project project = new Project();
			project.setDescription("description");
			project.setHistory("history");
			project.setName("project");
			project.setNeededAmount(100);
			project.setRemainingDays(7);
			project.setVideo("video");

			id = (int) session.save(project);
			session.flush();
		}
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("FROM Project");
			List<Project> projects = query.list();
			assertThat(projects.get(0).getDescription(), is("description"));
			assertThat(projects.get(0).getHistory(), is("history"));
			assertThat(projects.get(0).getName(), is("project"));
			assertThat(projects.get(0).getNeededAmount(), is(100));
			assertThat(projects.get(0).getRemainingDays(), is(7));
			assertThat(projects.get(0).getVideo(), is("video"));

			Project project = session.get(Project.class, id);
			assertThat(project.getDescription(), is("description"));
			assertThat(project.getHistory(), is("history"));
			assertThat(project.getName(), is("project"));
			assertThat(project.getNeededAmount(), is(100));
			assertThat(project.getRemainingDays(), is(7));
			assertThat(project.getVideo(), is("video"));
		}
	}

}
