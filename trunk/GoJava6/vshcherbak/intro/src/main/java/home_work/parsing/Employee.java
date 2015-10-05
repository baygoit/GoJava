package home_work.parsing;

public class Employee implements Comparable<Employee> {
    private int ID;
    private String name;
    private int managerID;

    public Employee(int ID, String name, int managerID) {
        this.ID = ID;
        this.name = name;
        this.managerID = managerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int compareTo(Employee employe) {
        if (managerID > employe.getManagerID()) {
            return 1;
        } else if (managerID < employe.getManagerID()) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", managerID=" + managerID +
                '}';
    }
}
