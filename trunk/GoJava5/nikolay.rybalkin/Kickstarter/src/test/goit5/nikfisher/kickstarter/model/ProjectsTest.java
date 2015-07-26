package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.dao.Projects;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class ProjectsTest {

    private Projects projects;

    @Before
    public void setup(){
        projects = getProjects();
    }

    abstract Projects getProjects();

    @Test
    public void  shouldProjectsWenNoProjectsWithNoSameCategory() throws Exception {
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
        Project[] found = projects.getProjects(category2);

        //then
        assertEquals(0, found.length);
    }
//
//    @Test
//    public void  shouldProjectsWenNoProjectsWithSameCategory() throws Exception {
//        //given
//        Category category1 = new Category("Game");
//        Category category2 = new Category("Design");
//
//        Project project1 = new Project("name1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
//        Project project2 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");
//        Project project3 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");
//
//        project1.setCategory(category1);
//        project2.setCategory(category2);
//        project3.setCategory(category2);
//
//        projects.add(project1);
//        projects.add(project2);
//        projects.add(project3);
//
//        //when
//        Project[] found = projects.getProjects(category2);
//
//        //then
//        assertEquals(2, found.length);
//        assertSame(project2, found[0]);
//        assertSame(project3, found[1]);
//    }

    @Test
    public void  shouldProjectsWenNoProjects() throws Exception {
        //given

        //when
        Project[] found = projects.getProjects(new Category("Game"));

        //then
        assertEquals(0, found.length);
    }

    @Test
    public void shouldProjectsIndex() throws Exception {
        //given

        //when
        Project project1 = new Project("name1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        projects.add(project1);
        Project project2 = new Project("name2 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        projects.add(project2);

        //then
        assertEquals(project1, projects.get(0));
        assertEquals(project2, projects.get(1));
    }
}
