package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

public interface DataStorage<T> {
    
    List<T> getAll() ;

    T get(int index);

    void add(T element);
    
    void addAll(List<T> elemens);
    
    void clear();
    
    default <K> void addFieldHandler(String fieldName, FieldHandler<K> handler){};
    
    public interface FieldHandler<K> {
        
        K handle(Object value);        
        
    }

}
