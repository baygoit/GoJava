package hm3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Parser {

    //strange method name and return type. method should parse file(s) and return always sorted collection not sorted array list
    public void parser(String file) throws IOException {

        //Set<Employee> employees = new TreeSet<>();
        //google: java always sorted collection and see the options
        List<Employee> employees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file)); //all input streams and readers must be closed when they are not needed anymore
        //check try-with-resource idiom in java

        String result;
        while ((result = br.readLine()) != null) {
            String[] parts = result.split(";");

            //introduce variable only when you need it
            Employee employee;
            int i = 0;
            while (i < parts.length) { //why the hell you need this cycle?
                int id = Integer.valueOf(parts[i]);
                String name = parts[i + 1]; //what if string is misformatted? you'll get array with only on element and i+1 which is always equal to 1 will throw ArrayIndexOutOfBoundsException
                int  managerId = Integer.valueOf(parts[i + 2]);
                employee = new Employee(id, name, managerId);
                i = i + 3;
                employees.add(employee);
            }
            //It's better to move code of creating an employee to distinct method which parses a line and returns Employee entity
        }

        Collections.sort(employees); //remove this line once found 'always sorted collection'
        System.out.println(employees.toString());
        //return employees;
    }
}


