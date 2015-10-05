package home_work.parsing;

import java.io.*;
import java.util.*;

public class Parsing {
    private static SortedSet<Employee> employes = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream(
                "C:\\Java\\GoJava\\trunk\\GoJava6\\vshcherbak\\intro\\src\\main\\java\\home_work\\parsing\\input.txt")));
        String input = "";
        while ( (input = fin.readLine()) != null ){
            String[] data = input.split(" ");
            int managerID = Integer.parseInt(data[0]);
            String name = data[1];
            int ID = Integer.parseInt(data[2]);
            //System.out.println(ID + " " + name + " " + managerID);
            Employee employee = new Employee(ID, name, managerID);
            employes.add(employee);
        }
        fin.close();
        for (Employee employee: employes) {
            System.out.println(employee);
        }
    }
}
