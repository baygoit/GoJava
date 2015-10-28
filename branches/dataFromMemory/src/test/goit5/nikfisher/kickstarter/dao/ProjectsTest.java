package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@SuppressWarnings("deprecation")
public abstract class ProjectsTest {

    private Projects projects;

    @Before
    public void setup() {
        projects = getProjects();
    }

    abstract Projects getProjects();

    @Test
    public void shouldProjectsWenNoProjectsWithNoSameCategory() {
        //given

        Category category1 = new Category("Game");
        Category category2 = new Category("Design");

        Project project1 = new Project("name1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");

        project1.setCategory(category1);
        project2.setCategory(category1);

        projects.add(project1);
        projects.add(project2);

        //when
        List<Project> found = projects.getProjects(category2);

        //then
        assertEquals(0, found.size());
    }

    @Test
    public void shouldProjectsWenNoProjectsWithSameCategory() {
        //given
        Category category1 = new Category("Game");
        Category category2 = new Category("Design");

        Project project1 = new Project("name1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Project project3 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");

        project1.setCategory(category1);
        project2.setCategory(category2);
        project3.setCategory(category2);

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        //when
        List<Project> found = projects.getProjects(category2);

        //then
        assertEquals(2, found.size());
        assertSame(project2, found.get(0));
        assertSame(project3, found.get(1));
    }

    @Test
    public void shouldProjectsWenNoProjects() {
        //given

        //when
        List<Project> found = projects.getProjects(new Category("Game"));

        //then
        assertEquals(0, found.size());
    }

    @Test
    public void shouldProjectsIndex() {
        //given
        Project project1 = new Project("Game \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Project project2 = new Project("Design \"New Design\"", 10000, 0, 10, "New innovation design");

        //when
        projects.add(project1);
        projects.add(project2);

        //then
        assertEquals(project1, projects.get(0));
        assertEquals(project2, projects.get(1));
    }
}
