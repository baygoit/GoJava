package com.gojava.view;

import static org.junit.Assert.*;
import org.junit.Test;

import com.gojava.projects.ProjectStorage;

public class Level2Test {
    ProjectStorage projectStorage = new ProjectStorage();
    @Test
    public void shouldGetNoProjects_WhenDisplayMySelf() {
        Level2 level2 = new Level2(projectStorage);
        String actual = level2.displayMySelf(0);
        assertEquals("", actual);
    }
}
