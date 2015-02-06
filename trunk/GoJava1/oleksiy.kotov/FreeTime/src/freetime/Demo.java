package freetime;
//
//import java.sql.Date;
//import java.util.Scanner;
//
public class Demo {
//
//    final static int N_EMPLOYEES = 4;
//    final static String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
//
//    static Employee[] empList = new Employee[N_EMPLOYEES];
//
//    Demo() {
//        // hardcoding
//        empList[0] = new Employee("Sergiy", "sergiy", "", "sergiy@gmail.com",
//                "111");
//        empList[1] = new Employee("Vasyl", "vasyl", "", "vasyl@gmail.com",
//                "111");
//        empList[2] = new Employee("Dmytro", "dmytro", "", "dmytro@gmail.com",
//                "111");
//        empList[3] = new Employee("Egor", "egor", "", "egor@gmail.com", "111");
//
//        for (int i = 16; i < 25; i++) {
//            
//            Date d = Date.valueOf("2015-02-" + i);
//
//            if (i % 2 == 0) {
//                empList[0].markDayFree(d);
//            }
//
//            if (i % 3 == 0) {
//                empList[1].markDayFree(d);
//            }
//
//            if (i % 4 == 0) {
//                empList[2].markDayFree(d);
//            }
//
//            empList[3].markDayFree(d);
//        }
//    }
//    
//
//    public static void main(String[] args) {
//
//        if (args.length == 0) {
//            System.out
//                    .println("Need key: m - for manager or e - for employee.\nBye!");
//            System.exit(0);
//        }
//
//        Scanner sc = new Scanner(System.in);
//
//        // Employee
//        if (args[0].equals("e")) {
//
//                System.out.print("\nHello Employee!\nEnter list of dates yyyy-mm-dd: ");
//                
//                while (sc.hasNext(DATE_PATTERN)) {
//
//                    String s = sc.next(DATE_PATTERN);
//                    Date d = Date.valueOf(s);
//                    empList[0].markDayFree(d);
//
//                }
//        }
//        // Manager
//        if (args[0].equals("m")) {
//            sc = new Scanner(System.in);
//                do {
//
//                    System.out
//                            .print("\nHello Manager!\nEnter date(yyyy-mm-dd): ");
//
//                    if (sc.hasNext(DATE_PATTERN)) {
//
//                        String s = sc.next("\\d{4}-\\d{2}-\\d{2}");
//
//                        for (Employee emp : empList) {
//                            Date date = Date.valueOf(s);
//                            if (emp.isDayFree(date)) {
//                                System.out.println(emp.getName());
//                            }
//                        }
//
//                    } else {
//                        System.out.print("Enter valid date or type exit.");
//                    }
//                } while (!sc.hasNext("exit"));
//
//
//        }
//    }
//    
//    
//     
}
