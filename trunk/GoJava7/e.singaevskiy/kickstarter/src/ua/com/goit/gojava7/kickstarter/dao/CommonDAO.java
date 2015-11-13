package ua.com.goit.gojava7.kickstarter.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommonDAO<T> {
    protected List<T> dataSource;

    protected CommonDAO() {
        dataSource = new ArrayList<>();
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(dataSource);
    }

    public T get(int index) {
        return dataSource.get(index);
    }

    public void add(T element) {
        dataSource.add(element);
    }

}
