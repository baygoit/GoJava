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
    public FotoStudio(String name, String address, String phone) {
        super(name, address, phone);
    }

    private Calendar reserveDate;
    private int reserveTime;

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
