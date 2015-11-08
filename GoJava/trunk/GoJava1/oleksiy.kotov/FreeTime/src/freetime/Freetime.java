package freetime;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Freetime {
    private static List<Employee> employees = new ArrayList<Employee>();

    // private Projects projects;
    // private Managers managers;

    public static void main(String[] args) throws IOException {
        Employee employee1 = new Employee(1, "Denis Denisov",
                "java,junit,agile");
        Employee employee2 = new Employee(2, "Ivan Popov", "java,junit,agile");
        Employee employee3 = new Employee(3, "Yuri Mahno",
                "scala,scrum,java,junit,agile");
        Employee employee4 = new Employee(4, "John Doe", "java,scrum");
        Employee employee5 = new Employee(5, "Petro Petrenko",
                "scrum,spring,java");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        
        showAllEmployees();
//        //save to file 
//        ObjectOutputStream objectOutputStream;
//             objectOutputStream = new ObjectOutputStream(
//                    new FileOutputStream("c:\\javaObjects.txt"));
//        
//        objectOutputStream.writeObject(employees);
//        objectOutputStream.flush();
//        objectOutputStream.close();
        
        // view all free employees for today
        // view all free employees for peroid of dates
        
    }

    private static void showAllEmployees() {
        
        // view all employees
        // name, skills
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Skills: " + employee.getSkills().toString());
            System.out.println("------------------------------");
        }
    }
}
