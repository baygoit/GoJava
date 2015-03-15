/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private int reserveId;
    private Date reserveDate;
    private String workTime;

    public Reserve() {
        // TODO Auto-generated constructor stub
    }
     
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((reserveDate == null) ? 0 : reserveDate.hashCode());
        result = prime * result + reserveId;
        result = prime * result
                + ((workTime == null) ? 0 : workTime.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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
        if (reserveId != other.reserveId)
            return false;
        if (workTime == null) {
            if (other.workTime != null)
                return false;
        } else if (!workTime.equals(other.workTime))
            return false;
        return true;
    }

    /**
     * @return the reserveId
     */
    public int getReserveId() {
        return reserveId;
    }

    /**
     * @param reserveId the reserveId to set
     */
    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    /**
     * @return the reserveDate
     */
    public Date getReserveDate() {
        return reserveDate;
    }

    /**
     * @param reserveDate the reserveDate to set
     */
    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    /**
     * @return the workTime
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * @param workTime the workTime to set
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

}
