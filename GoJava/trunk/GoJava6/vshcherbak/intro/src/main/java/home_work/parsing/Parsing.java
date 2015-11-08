package home_work.parsing;

import java.io.BufferedReader;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.IOException;

public class Parsing  {
    private Set<Employee> employes = new TreeSet<>();

    public void parser(BufferedReader fin) {
        String input = "";
        try {
            while ((input = fin.readLine()) != null) {
                String[] data = input.split(" ");
                int managerID = Integer.parseInt(data[0]);
                String name = data[1];
                int ID = Integer.parseInt(data[2]);
                Employee employee = new Employee(ID, name, managerID);
                employes.add(employee);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getEmployes() {
        String out = "";
        for (Employee employee: employes) {
            out += employee;
        }
        return out;
    }
}
