/**
 * 
 */
package alexkholmov.organizer.logic;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author SASH
 *
 */
@Entity
@Table(name="reserve")
public class Reserve {
    
    @Id
    @GeneratedValue
    @Column(name="res_id")
    private int reserveId;
    
    @Column(name="res_date")
    private Date reserveDate;
    
    @Column(name="work_time")
    private String workTime;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="stud_id")
    private FotoStudio studio;
    
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

    /**
     * @return the studio
     */
    public FotoStudio getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(FotoStudio studio) {
        this.studio = studio;
    }

}
