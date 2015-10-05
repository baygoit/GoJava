/**
 * Created by Ыўср on 04.10.2015.
 */

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.Set;

import java.util.TreeSet;

public class Parser {

    static Set<Employee> employees = new TreeSet();

    public static void main(String[] args) throws IOException {

        BufferedReader stream = null;
        String b;
        String[] str;
        try {

            stream = new BufferedReader(new FileReader("File1.txt"));

            while ((b = stream.readLine()) != null) {
                System.out.println(b);

            }
        } finally {
            stream.close();
        }


        str = new String[b.length()];
        str = b.split(" ");
        for (int i = 0; i < str.length; i += 3) {
            Employee emploee = new Employee();

            emploee.emploeeID = Integer.parseInt(str[i]);
            emploee.name = str[i + 1];
            emploee.managerID = Integer.parseInt(str[i + 2]);

            employees.add(emploee);

        }
        System.out.println(employees.toString());

    }

}