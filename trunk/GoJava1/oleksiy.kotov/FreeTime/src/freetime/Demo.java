package freetime;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) {
        final int N_EMPLOYEES = 3;
        Employee[] empList = new Employee[N_EMPLOYEES];

        empList[0] = new Employee("Sergiy", "sergiy", "", "sergiy@gmail.com",
                "111");
        empList[1] = new Employee("Vasyl", "vasyl", "", "vasyl@gmail.com",
                "111");
        empList[2] = new Employee("Dmytro", "dmytro", "", "dmytro@gmail.com",
                "111");

        if (args.length == 0) {
            System.out
                    .println("Need key: m - for manager or e - for employee.\nBye!");
            System.exit(0);
        }

        Scanner sc = new Scanner(System.in);
        if (args[0].toLowerCase().equals("m")) {

            do {
                
                System.out.print("Hello Manager!\n Enter date(yyyy-mm-dd): ");
                
                if (sc.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
                    
                    String s =sc.next("\\d{4}-\\d{2}-\\d{2}");
                    
                    for (Employee emp : empList) {
                        if (emp.isFree(Date.valueOf(s))) {
                            System.out.println(emp.getName());
                        }
                    }
                    
                    //System.out.println(emp.getName());
                } else {
                    System.out.print("Enter valid date or type exit.");
                }
            } while (!sc.hasNext("exit"));

        }

        sc.close();

    }

}