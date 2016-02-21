package com.kickstarter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Игорь on 21.02.2016.
 */
public class ProjectsTest {

    @Test
    public void shouldEmptyProjects_whenNoProjects () {
        Projects list = new Projects();

        Project[] found = list.getProjects(new Category("name1"));

        assertEquals(0, found.length);
    }

    @Test
    public void shouldEmptyProjects_whenNoProjectsWithSameCategory () {
        Category category = new Category("category");

        Projects list = new Projects();

        Project project1 = new Project("name", 100, 10, "video", "description");
        project1.setCategory(category);

        Project project2 = new Project("name2", 100, 10, "video2", "description2");
        project2.setCategory(category);

        list.add(project1);
        list.add(project2);

        Project[] found = list.getProjects(new Category("name1"));

        assertEquals(0, found.length);
    }

    @Test
    public void shouldFoundProjects_whenExistsProjectWithCategory(){
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");

        Projects list = new Projects();

        Project project1 = new Project("name", 100, 10, "video", "description");
        project1.setCategory(category1);

        Project project2 = new Project("name2", 100, 10, "video2", "description2");
        project2.setCategory(category2);

        Project project3 = new Project("name3", 100, 10, "video3", "description3");
        project3.setCategory(category2);

        list.add(project1);
        list.add(project2);
        list.add(project3);

        Project[] found = list.getProjects(category2);

        assertEquals(2, found.length);
        assertSame(project2, found[0]);
        assertSame(project3, found[1]);
    }

    @Test
    public void shouldSetProjects_whenExistsSomeProjects(){

        Projects list = new Projects();

        Project project1 = new Project("name", 100, 10, "video", "description");

        Project project2 = new Project("name2", 100, 10, "video2", "description2");

        list.add(project1);
        list.add(project2);

        assertSame(project1, list.get(0));
        assertSame(project2, list.get(1));
    }
}
