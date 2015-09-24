package hm3;

public class Employee implements Comparable<Employee>{

    int id; //why don't fields private, where is incapsulation?
    String name;
    int managerId;


    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    public int compareTo(Employee employee) {
        return managerId-employee.managerId; //never use '-' when compare - read about numbers overflow. better use Integer.compare(int, int)
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                '}';
    }




}
