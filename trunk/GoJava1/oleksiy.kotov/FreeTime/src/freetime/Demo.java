package freetime;

import java.sql.Date;
import java.util.Scanner;

public class Demo {
    
    final static int N_EMPLOYEES = 4;
    final static String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    
    static Employee[] empList = new Employee[N_EMPLOYEES];

    Demo() {
        // hardcoding
        empList[0] = new Employee("Sergiy", "sergiy", "", "sergiy@gmail.com",
                "111");
        empList[1] = new Employee("Vasyl", "vasyl", "", "vasyl@gmail.com",
                "111");
        empList[2] = new Employee("Dmytro", "dmytro", "", "dmytro@gmail.com",
                "111");
        empList[3] = new Employee("Egor", "egor", "", "egor@gmail.com", "111");

        for (int i = 16; i < 30; i++) {
            Date d = Date.valueOf("2015-01-" + i);

            if (i % 2 == 0) {
                empList[0].addFreeDay(d);
            }

            if (i % 3 == 0) {
                empList[1].addFreeDay(d);
            }

            if (i % 4 == 0) {
                empList[2].addFreeDay(d);
            }

            empList[3].addFreeDay(d);
        }

    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out
                    .println("Need key: m - for manager or e - for employee.\nBye!");
            System.exit(0);
        }

        // manager
        if (args[0].equals("m")) {
            Scanner sc = new Scanner(System.in);
            if (args[0].toLowerCase().equals("m")) {

                do {

                    System.out
                            .print("\nHello Manager!\nEnter date(yyyy-mm-dd): ");

                    if (sc.hasNext(DATE_PATTERN)) {

                        String s = sc.next("\\d{4}-\\d{2}-\\d{2}");

                        for (Employee emp : empList) {
                            if (emp.isFree(Date.valueOf(s))) {
                                System.out.println(emp.getName());
                            }
                        }

                    } else {
                        System.out.print("Enter valid date or type exit.");
                    }
                } while (!sc.hasNext("exit"));

            }

            sc.close();
        }

    }
}