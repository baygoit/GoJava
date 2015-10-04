/**
 * Created by Ыўср on 04.10.2015.
 */

public class Employee implements Comparable<Employee> {

    int emploeeID;
    String name;
    int managerID;

    public Employee() {

    }

    public Employee(int emploeeID, String name, int managerID) {
        this.emploeeID = emploeeID;
        this.name = name;
        this.managerID = managerID;
    }


    @Override
    public String toString() {
        return "Employee : " + "emploee ID - " + emploeeID + ", name - " + name + ", manager ID - " + managerID + " ";
    }


    public int compareTo(Employee employee) {

        return Integer.compare(managerID, employee.managerID);
    }

}

