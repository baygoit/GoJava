package freetime;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Manager extends User {

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees,
            Date start, Date end, Set<String> skillList) throws ParseException {

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

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees) throws ParseException {

        return findFreeEmployees(employees, new Date());
    }

    public ArrayList<Employee> findFreeEmployees(ArrayList<Employee> employees,
            Date date) throws ParseException {

        return findFreeEmployees(employees, date, date, new HashSet<String>());
    }

}
