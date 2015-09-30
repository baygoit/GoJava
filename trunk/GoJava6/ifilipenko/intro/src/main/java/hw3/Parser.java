package hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Parser {
    PriorityQueue<Employee> employees = new PriorityQueue<>();

    public PriorityQueue<Employee> parseFileTextToSortedEmployeeList(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result;

        try {
            while ((result = br.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(result, ";");
                int id = 0;
                int managerId = 0;
                String name = null;

                if (token.hasMoreTokens()) {
                    id = Integer.valueOf(token.nextToken());
                }
                if (token.hasMoreTokens()) {
                    name = token.nextToken();
                }
                if (token.hasMoreTokens()) {
                    managerId = Integer.valueOf(token.nextToken());
                }
                addEmployee(id, name, managerId);
            }
        } finally {
            br.close();
        }
        return employees;

    }

    private void addEmployee(int id, String name, int managerId) {
        Employee employee = new Employee(id, name, managerId);
        employees.add(employee);
    }

}


