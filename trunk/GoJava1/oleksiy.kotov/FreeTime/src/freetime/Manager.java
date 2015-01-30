package freetime;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.hamcrest.core.IsNull;

public class Manager extends User {

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees,
            Date start, Date end, String[] skillList) throws ParseException {

        ArrayList<Employee> list = new ArrayList<Employee>();

        if (employees == null) {
            return list;
        }

        for (Employee employee : employees) {

            if (employee.isPeriodHasFreeDay(start, end)) {

                for (String skill : skillList) {
                    if (employee.hasSkill(skill)) {
                        list.add(employee);
                        break;
                    }
                }

            }
        }

        return list;
    }

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees) {

        return findFreeEmployees(employees, new Date());
    }

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees,
            Date date) {
        
        return findFreeEmployees(employees, date, date, "");
    }

}
