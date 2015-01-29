/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hamcrest.Condition.Step;

/**
 * @author SASH
 *
 */
public class Order {
    private static final int TIME_WORKING_IN_DAY = 4; //hours
    
    private int amountDays;
    private Calendar deadline;
    private Calendar startWork;
    private Calendar endWork;
    private Customer customer;
    private SellService service;
    
    void setDeadline(int year, int month, int date) {
        deadline = new GregorianCalendar();
        deadline.set(year, Calendar.MONTH, date);
    }
    
    void setStartWork(int year, int month, int date) {
        startWork = new GregorianCalendar();
        startWork.set(year, Calendar.MONTH, date);
    }
    
    int timeEditFotosInService(SellService service) {
        int timeSum = 0;
        for (PackageFotos pf : service.packagesFotos) {
            timeSum += pf.timeEditingAllFotos();
        }
        return timeSum;
    }
    
    void daysEditFotosInService(int hTime) {
        amountDays = hTime / TIME_WORKING_IN_DAY;
    }
    
    void setEndWork() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date1 = dateFormat.format(startWork.getTime());
        try {
            Date dateParse = dateFormat.parse(date1);
            endWork = new GregorianCalendar();
            endWork.setTime(dateParse);
            endWork.add(Calendar.DAY_OF_MONTH, amountDays);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    void displayOrder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(amountDays);
        System.out.println(dateFormat.format(deadline.getTime()));
        System.out.println(dateFormat.format(startWork.getTime()));
        System.out.println(dateFormat.format(endWork.getTime()));
    }
}
