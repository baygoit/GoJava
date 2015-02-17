package com.gojava.projects;

public class TestInMemoryProjectStorage extends TestProjectStorage{

    @Override
    ProjectStorage getProjectStorage() {
        return new InMemoryProjectStorage();
    }

}
