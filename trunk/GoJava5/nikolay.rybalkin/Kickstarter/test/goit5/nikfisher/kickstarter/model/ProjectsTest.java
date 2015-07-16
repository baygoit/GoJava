package test.goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.Projects;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ProjectsTest {

    @Test
    public void  shouldProjectsWenNoProjectsWithNoSameCategory() throws Exception {
        //given
        Projects projects = new Projects();
        Category category1 = new Category("Game");
        Category category2 = new Category("Design");

        Project project1 = new Project("name1 \"Popcorn\"", 10000, 10, "Interesting game");
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 10, "Interesting game");

        project1.setCategory(category1);
        project2.setCategory(category1);

        projects.add(project1);
        projects.add(project2);

        //when
        Project[] found = projects.getProgects(category2);

        //then
        assertEquals(0, found.length);
    }

    @Test
    public void  shouldProjectsWenNoProjectsWithSameCategory() throws Exception {
        //given
        Projects projects = new Projects();
        Category category1 = new Category("Game");
        Category category2 = new Category("Design");

        Project project1 = new Project("name1 \"Popcorn\"", 10000, 10, "Interesting game");
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 10, "Interesting game");
        Project project3 = new Project("name2 \"Popcorn\"", 10000, 10, "Interesting game");

        project1.setCategory(category1);
        project2.setCategory(category2);
        project3.setCategory(category2);

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        //when
        Project[] found = projects.getProgects(category2);

        //then
        assertEquals(2, found.length);
        assertSame(project2, found[0]);
        assertSame(project3, found[1]);
    }

    @Test
    public void  shouldProjectsWenNoProjects() throws Exception {
        //given
        Projects projects = new Projects();

        //when
        Project[] found = projects.getProgects(new Category("Game"));

        //then
        assertEquals(0, found.length);
    }

    @Test
    public void shouldProjectsIndex() throws Exception {
        //given
        Projects projects = new Projects();

        //when
        Project project1 = new Project("name1 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project1);
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project2);

        //then
        assertEquals(project1, projects.get(0));
        assertEquals(project2, projects.get(1));
    }
}