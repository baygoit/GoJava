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
public class Order {
    private Calendar deadline;
    private Calendar startWork;
    Calendar endWork;
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
    
    void calcEndWork(int amountDays) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String startWorkDate = dateFormat.format(startWork.getTime());
        try {
            Date dateParse = dateFormat.parse(startWorkDate);
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
        System.out.println(dateFormat.format(deadline.getTime()));
        System.out.println(dateFormat.format(startWork.getTime()));
        System.out.println(dateFormat.format(endWork.getTime()));
    }
}
