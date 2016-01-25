package ua.com.goit.gojava7.kickstarter.datasource.contract;

import java.util.List;

public interface DataSource<T> {
    
    List<T> getAll() ;

    T get(Long index);

    void add(T element);
    
    void addAll(List<T> elemens);
    
    void clear();

}
