package hw3;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public Employee() {
    }

    @Override
    public int compareTo(Employee employee) {
        return managerId < employee.managerId? -1:(managerId == employee.managerId? 0: 1);
        //return Integer.compare(managerId, employee.managerId);
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
