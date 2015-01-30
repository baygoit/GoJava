package freetime;

import java.util.ArrayList;

public interface SearchRequest {
    void fillParams();
    ArrayList<Employee> find();
}
