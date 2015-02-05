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
public class Reserve implements ShowInfo{
    private Calendar reserveDate;
    private int reserveTime;

    public Reserve(int reserveTime) {
        //create reserve studio with current date and time
        Calendar reserveDate = new GregorianCalendar();
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
    }
    
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

    Calendar getReserveDate() {
        return reserveDate;
    }
    
    void setReserveDate(int year, int month, int date, int hourOfDay, int minute) {
        reserveDate = new GregorianCalendar();
        reserveDate.set(year, Calendar.MONTH, date, hourOfDay, minute);
    }
    
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println("Студия зарезарвирована на " + dateFormat.format(reserveDate.getTime()));
        System.out.println("Время работы в студии " + reserveTime + " часов");
    }
}
