/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author SASH
 *
 */
public class Schedule {
    static int TIME_WORKING_IN_WORK_DAY = 3; //hours
    static int TIME_WORKING_IN_DAY_OFF = 6; //hours
    static String PATTERN = "dd.MM.yyyy";
    
    private int amountDays = 0;
    private WorkWithFotos workWithFotos;
    
    Calendar deadline;
    Calendar startWork;
    Calendar endWork;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    
    WorkWithFotos getWorkWithFotos() {
        return workWithFotos;
    }

    void setWorkWithFotos(WorkWithFotos workWithFotos) {
        this.workWithFotos = workWithFotos;
    }

    int getAmountDays() {
        return amountDays;
    }

    // set amount days manually
    void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }
    
    void setDeadline(String date) {
        try {
            Date dateParse = dateFormat.parse(date);
            deadline = Calendar.getInstance();
            deadline.setTime(dateParse);
        } catch (ParseException e) {
            // TODO: handle exception
            System.err.print(e.getMessage());
        }
    }
    
    void setStartWork(String date) {
        try {
            Date dateParse = dateFormat.parse(date);
            startWork = Calendar.getInstance();
            startWork.setTime(dateParse);
        } catch (ParseException e) {
            // TODO: handle exception
            System.err.print(e.getMessage());
        }
    }
    
    void calcEndWork() throws Exception {
        String startWorkDate = dateFormat.format(startWork.getTime());
        int workHours = workWithFotos.timeEditingFotosInPackage();
        boolean condition;
        try {
            Date dateParse = dateFormat.parse(startWorkDate);
            endWork = Calendar.getInstance(); 
            endWork.setTime(dateParse);
            int i = 1;
            while (workHours >= 0) {
                condition = endWork.get(Calendar.DAY_OF_WEEK) == 1 || endWork.get(Calendar.DAY_OF_WEEK) == 7;
                workHours = condition ? workHours - TIME_WORKING_IN_DAY_OFF : workHours - TIME_WORKING_IN_WORK_DAY;
                endWork.add(Calendar.DAY_OF_MONTH, i);
                amountDays++;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.err.print(e.getMessage());
        }
    }
    
    boolean isOutOfDeadline() {  
        if (endWork.after(deadline)) {
            int i = 1;
            while (endWork.after(deadline)) {
                endWork.add(Calendar.DAY_OF_MONTH, -i);
                startWork.add(Calendar.DAY_OF_MONTH, -i);
                i++;
            }
            return true;
        } else {
            return false;
        }
    }

}
