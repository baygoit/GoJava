package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

public interface DataSource<T> {
    
    List<T> getAll() ;

    T get(int index);

    void add(T element);
    
    void addAll(List<T> elemens);
    
    void clear();

}
