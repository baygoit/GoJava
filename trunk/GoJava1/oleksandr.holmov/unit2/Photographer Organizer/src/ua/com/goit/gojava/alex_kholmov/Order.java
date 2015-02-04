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
public class Order {
    private final String MSG_1 = "Дата окончания работы выходит за пределы даты, указанной в договоре";
    private final String MSG_2 = "Исходя из выбранной дневной нагрузки,\nрекомендуется установить дату начала работ\nне позднее: ";
    
    Calendar deadline;
    Calendar startWork;
    Calendar endWork;
    private Customer customer;
    private FotoStudio fotoStudio;
    private SellService service;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    void setFotoStudio(FotoStudio fotoStudio) {
        this.fotoStudio = fotoStudio;
    }

    void setDeadline(int year, int month, int date) {
        deadline = new GregorianCalendar();
        deadline.set(year, Calendar.MONTH, date);
    }
    
    void setStartWork(int year, int month, int date) {
        startWork = new GregorianCalendar();
        startWork.set(year, Calendar.MONTH, date);
    }
    
    void calcEndWork(int amountDays) {
        String startWorkDate = dateFormat.format(startWork.getTime());
        try {
            Date dateParse = dateFormat.parse(startWorkDate);
            endWork = new GregorianCalendar();
            endWork.setTime(dateParse);
            endWork.add(Calendar.DAY_OF_MONTH, amountDays);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    void checkWorkDays() {  
        if (endWork.after(deadline)) {
            System.out.println(MSG_1);
            int i = 1;
            while (endWork.after(deadline)) {
                endWork.add(Calendar.DAY_OF_MONTH, -i);
                startWork.add(Calendar.DAY_OF_MONTH, -i);
                i++;
            }
            System.out.println(MSG_2 + dateFormat.format(startWork.getTime()));
        }
    }
    
    void displayOrder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Дата окончания работ по договору: " + dateFormat.format(deadline.getTime()));
        System.out.println("Дата начала работы: " + dateFormat.format(startWork.getTime()));
        System.out.println("Посчитанная дата окончания работы: " + dateFormat.format(endWork.getTime()));
        customer.printInfo();
        fotoStudio.printInfo();
    }
}
