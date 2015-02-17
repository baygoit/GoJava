package com.gojava.projects;

public class TestInFileProjectStorage extends TestProjectStorage{

    @Override
    ProjectStorage getProjectStorage() {
        return new InFileProjectStorage("testProgects.txt");
    }

}
