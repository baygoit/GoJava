package hm3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Parser {

    public void parser(String file) throws IOException {

        //Set<Employee> employees = new TreeSet<>();
        List<Employee> employees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String result;
        while ((result = br.readLine()) != null) {
            String[] parts = result.split(";");
            Employee employee;
            int i = 0;
            while (i < parts.length) {
                int id = Integer.valueOf(parts[i]);
                String name = parts[i + 1];
                int  managerId = Integer.valueOf(parts[i + 2]);
                employee = new Employee(id, name, managerId);
                i = i + 3;
                employees.add(employee);
            }
        }

        Collections.sort(employees);
        System.out.println(employees.toString());

    }
}


