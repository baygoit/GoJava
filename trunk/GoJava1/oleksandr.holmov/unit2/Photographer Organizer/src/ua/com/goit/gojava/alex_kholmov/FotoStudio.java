/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author SASH
 *
 */
public class FotoStudio extends Contacts {
    private Calendar reserveDate;
    private int reserveTime;
    
    public FotoStudio(String name, String address, String phone, int reservTime) {
        super(name, address, phone);
        this.reserveTime = reservTime;
    }

    int getReserveTime() {
        return reserveTime;
    }
    void setReserveTime(int reserveTime) {
        this.reserveTime = reserveTime;
    }
    
    void displayReserveDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println(dateFormat.format(reserveDate.getTime()));
        System.out.println("Time to work in studio " + reserveTime + " hours");
    }
    
    void setReserveDate(int year, int month, int date, int hourOfDay, int minute) {
        reserveDate = new GregorianCalendar();
        reserveDate.set(year, Calendar.MONTH, date, hourOfDay, minute);
    }
}
