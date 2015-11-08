package com.gojava.projects;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

public class TestInFileProjectStorage extends TestProjectStorage {

    ArrayList<Project> resultList;
    InFileProjectStorage inFileProjectStorage;

    @Before
    public void setListCategories() {
        resultList = inFileProjectStorage.getProjectsFromFileToList();
    }

    @Override
    ProjectStorage getProjectStorage() {
        inFileProjectStorage = new InFileProjectStorage("testProjects.txt");
        return inFileProjectStorage;
    }

    @After
    public void cleanUp() {
        inFileProjectStorage.file.delete();
    }
}
