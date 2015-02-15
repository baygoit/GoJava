package com.gojava.projects;

public class TestInMemoryCategryStorage extends TestCategoryStorage{

    @Override
    CategoryStorage getCategoryStorage() {
        return new InMemoryCategoryStorage();
    }

}
