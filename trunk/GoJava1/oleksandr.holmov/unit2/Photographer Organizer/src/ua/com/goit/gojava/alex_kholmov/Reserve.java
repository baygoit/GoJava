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
public class Reserve {
    private Date reserveDate;
    private int reserveTime;
    static String PATTERN = "dd.MM.yyyy HH:mm";
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((reserveDate == null) ? 0 : reserveDate.hashCode());
        result = prime * result + reserveTime;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserve other = (Reserve) obj;
        if (reserveDate == null) {
            if (other.reserveDate != null)
                return false;
        } else if (!reserveDate.equals(other.reserveDate))
            return false;
        if (reserveTime != other.reserveTime)
            return false;
        return true;
    }

    int getReserveTime() {
        return reserveTime;
    }
    
    void setReserveTime(int reserveTime) {
        this.reserveTime = reserveTime;
    }

    String getReserveDate() {
        return dateFormat.format(reserveDate);
    }
    
    void setReserveDate(String date) {
        try {
            reserveDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.err.print(e.getMessage());
        }
    }
    
}
