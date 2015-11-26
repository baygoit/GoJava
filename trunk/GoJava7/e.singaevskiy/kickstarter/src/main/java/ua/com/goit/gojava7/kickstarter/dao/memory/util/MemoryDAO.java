package ua.com.goit.gojava7.kickstarter.dao.memory.util;

import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DataSource;

public abstract class MemoryDAO<T> implements DataSource<T> {
    protected List<T> dataSource;

    public MemoryDAO(List<T> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(dataSource);
    }

    @Override
    public T get(int index) {
        return dataSource.get(index);
    }

    @Override
    public void add(T element) {
        dataSource.add(element);
    }

    @Override
    public void addAll(List<T> elemens) {
        dataSource.addAll(elemens);
    }
    
    @Override
    public void clear() {
        dataSource.clear();
    }

}
