package freetime;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class FreeEmployees implements SearchRequest {

    private Date start;
    private Date end;
    ArrayList<Employee> list;

    public FreeEmployees(ArrayList<Employee> list) {
        start = new Date();
        end = new Date();
        this.list = list;

        System.out.println("Start date:" + start);
        System.out.println("End date:" + end);
    }

    @Override
    public void fillParams() {

    }

    @Override
    public ArrayList<Employee> find() {
        
        ArrayList<Employee> resultSearch = new ArrayList<Employee>();
        for(Employee employee: list) {
            try {
                if (employee.isPeriodHasFreeDay(start, end)) {
                    resultSearch.add(employee);
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return resultSearch;
    }

}
