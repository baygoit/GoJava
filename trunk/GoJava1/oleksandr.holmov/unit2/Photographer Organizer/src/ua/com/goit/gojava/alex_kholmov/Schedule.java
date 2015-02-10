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
public class Schedule implements ShowInfo{
    //private final String MSG_1 = "Дата окончания работы выходит за пределы даты, указанной в договоре";
    //private final String MSG_2 = "Исходя из выбранной дневной нагрузки,\nрекомендуется установить дату начала работ\nне позднее: ";
    
    static int TIME_WORKING_IN_WORK_DAY = 3; //hours
    static int TIME_WORKING_IN_DAY_OFF = 6; //hours
    
    private int amountDays = 0;
    private WorkWithFotos workWithFotos;
    
    Calendar deadline;
    Calendar startWork;
    Calendar endWork;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    WorkWithFotos getWorkWithFotos() {
        return workWithFotos;
    }

    void setWorkWithFotos(WorkWithFotos workWithFotos) {
        this.workWithFotos = workWithFotos;
    }

    int getAmountDays() {
        return amountDays;
    }

    // set amount days manually
    void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }
    
    void setDeadline(int year, int month, int date) {
        deadline = Calendar.getInstance(); 
        deadline.set(year, Calendar.MONTH, date);
    }
    
    void setStartWork(int year, int month, int date) {
        startWork = Calendar.getInstance(); 
        startWork.set(year, Calendar.MONTH, date);
    }
    
    void calcEndWork() {
        String startWorkDate = dateFormat.format(startWork.getTime());
        int workHours = workWithFotos.timeEditingFotosInPackage();
        boolean condition;
        try {
            Date dateParse = dateFormat.parse(startWorkDate);
            endWork = Calendar.getInstance(); 
            endWork.setTime(dateParse);
            int i = 1;
            while (workHours >= 0) {
                condition = endWork.get(Calendar.DAY_OF_WEEK) == 1 || endWork.get(Calendar.DAY_OF_WEEK) == 7;
                workHours = condition ? workHours - TIME_WORKING_IN_DAY_OFF : workHours - TIME_WORKING_IN_WORK_DAY;
                endWork.add(Calendar.DAY_OF_MONTH, i);
                amountDays++;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    boolean isOutOfDeadline() {  
        if (endWork.after(deadline)) {
            int i = 1;
            while (endWork.after(deadline)) {
                endWork.add(Calendar.DAY_OF_MONTH, -i);
                startWork.add(Calendar.DAY_OF_MONTH, -i);
                i++;
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void displayInfo() {
        System.out.println("Дата окончания работ по договору: " + dateFormat.format(deadline.getTime()));
        System.out.println("Дата начала работы: " + dateFormat.format(startWork.getTime()));
        System.out.println("Посчитанная дата окончания работы: " + dateFormat.format(endWork.getTime()));
    }
}
