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

    int getReserveTime() {
        return reserveTime;
    }
    void setReserveTime(int reserveTime) {
        this.reserveTime = reserveTime;
    }
    
    String displayReserveDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        return dateFormat.format(reserveDate.getTime());
    }
    
    void setReserveDate(int year, int month, int date, int hourOfDay, int minute) {
        reserveDate = new GregorianCalendar();
        reserveDate.set(year, month, date, hourOfDay, minute);
    }
}
