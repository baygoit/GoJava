/**
 * 
 */
package alexkholmov.organizer.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author SASH
 *
 */
@Entity
@Table(name="schedule")
public class Schedule {
    
    @Id
    @GeneratedValue
    @Column(name="sch_id")
    private int scheduleId;
    
    @Column(name="sch_days")
    private int amountDays = 0;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="schedule")
    private List<PackageFotos> allFotos;
    
    @Column(name="sch_deadline")
    private Date deadline;
    
    @Column(name="sch_startwork")
    private Date startWork;
    
    @Column(name="sch_endwork")
    private Date endWork;
    
    @Column(name="sch_inworkdays")
    static int TIME_WORKING_IN_WORK_DAY = 3; //hours
    
    @Column(name="sch_indayoff")
    static int TIME_WORKING_IN_DAY_OFF = 6; //hours
    
    static String PATTERN = "dd.MM.yyyy";
    private SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    
    /**
     * @return the scheduleId
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId the scheduleId to set
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return the amountDays
     */
    public int getAmountDays() {
        return amountDays;
    }

    /**
     * @param amountDays the amountDays to set manually
     */
    public void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }

    /**
     * @return the allFotos
     */
    public List<PackageFotos> getAllFotos() {
        return allFotos;
    }

    /**
     * @param allFotos the allFotos to set
     */
    public void setAllFotos(List<PackageFotos> allFotos) {
        this.allFotos = allFotos;
    }

    /**
     * @return the tIME_WORKING_IN_WORK_DAY
     */
    public static int getTIME_WORKING_IN_WORK_DAY() {
        return TIME_WORKING_IN_WORK_DAY;
    }

    /**
     * @param tIME_WORKING_IN_WORK_DAY the tIME_WORKING_IN_WORK_DAY to set
     */
    public static void setTIME_WORKING_IN_WORK_DAY(int tIME_WORKING_IN_WORK_DAY) {
        TIME_WORKING_IN_WORK_DAY = tIME_WORKING_IN_WORK_DAY;
    }

    /**
     * @return the tIME_WORKING_IN_DAY_OFF
     */
    public static int getTIME_WORKING_IN_DAY_OFF() {
        return TIME_WORKING_IN_DAY_OFF;
    }

    /**
     * @param tIME_WORKING_IN_DAY_OFF the tIME_WORKING_IN_DAY_OFF to set
     */
    public static void setTIME_WORKING_IN_DAY_OFF(int tIME_WORKING_IN_DAY_OFF) {
        TIME_WORKING_IN_DAY_OFF = tIME_WORKING_IN_DAY_OFF;
    }

    /**
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the startWork
     */
    public Date getStartWork() {
        return startWork;
    }

    /**
     * @param startWork the startWork to set
     */
    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    /**
     * @return the endWork
     */
    public Date getEndWork() {
        return endWork;
    }

    /**
     * @param endWork the endWork to set
     */
    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public void addPackage(PackageFotos pFotos) {
        allFotos.add(pFotos);
    }
    
    public void removePackage(PackageFotos pFotos) {
        allFotos.remove(pFotos);
    }
    
    public int amountPackage() {
        return allFotos.size();
    }
    
    private int timeEditingAllFotos() {
        int timeToEditAllPhotos = 0;
        for (PackageFotos packageFotos : allFotos) {
            timeToEditAllPhotos += packageFotos.timeEditAllFotos() / 60;
        }
        return timeToEditAllPhotos;
    }
    
    public void calcEndWork() throws Exception {
        int workHours = timeEditingAllFotos();
        boolean condition;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startWork);
        int i = 1;
        while (workHours >= 0) {
            condition = calendar.get(Calendar.DAY_OF_WEEK) == 1
                    || calendar.get(Calendar.DAY_OF_WEEK) == 7;
            workHours = condition ? workHours - TIME_WORKING_IN_DAY_OFF
                    : workHours - TIME_WORKING_IN_WORK_DAY;
            calendar.add(Calendar.DAY_OF_MONTH, i);
            amountDays++;
        }
        endWork = calendar.getTime();
    }
    
    public boolean isOutOfDeadline() {  
        Calendar calendarEW = Calendar.getInstance();
        Calendar calendarSW = Calendar.getInstance();
        Calendar calendarDL = Calendar.getInstance();
        calendarEW.setTime(endWork);
        calendarSW.setTime(startWork);
        calendarDL.setTime(deadline);
        if (calendarEW.after(calendarDL)) {
            int i = 1;
            while (calendarEW.after(deadline)) {
                calendarEW.add(Calendar.DAY_OF_MONTH, -i);
                calendarSW.add(Calendar.DAY_OF_MONTH, -i);
                i++;
            }
            startWork = calendarSW.getTime();
            endWork = calendarEW.getTime();
            return true;
        } else {
            return false;
        }
    }

}
