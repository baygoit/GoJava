/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author SASH
 *
 */
public class Schedule {
    static int TIME_WORKING_IN_WORK_DAY = 3; //hours
    static int TIME_WORKING_IN_DAY_OFF = 6; //hours
    static String PATTERN = "dd.MM.yyyy";
    private SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    private Date deadline;
    private Date startWork;
    private Date endWork;
    
    private int scheduleId;
    private int amountDays = 0;
    private WorkWithFotos workWithFotos;
    
    WorkWithFotos getWorkWithFotos() {
        return workWithFotos;
    }

    public void setWorkWithFotos(WorkWithFotos workWithFotos) {
        this.workWithFotos = workWithFotos;
    }

    public int getAmountDays() {
        return amountDays;
    }

    // set amount days manually
    void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
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
    
    public void calcEndWork() throws Exception {
        int workHours = workWithFotos.timeEditingFotosInPackage();
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
