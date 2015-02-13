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
    private Customer customer;
    private FotoStudio fotoStudio;
    private SellService service;
    private Schedule schedule;
    private static int orderId;

    public Order(Customer customer, FotoStudio fotoStudio, SellService service, Schedule schedule) {
        // TODO Auto-generated constructor stub
        this.customer = customer;
        this.fotoStudio = fotoStudio;
        this.service = service;
        this.schedule = schedule;
        orderId++;
    }

    static int getId() {
        return orderId;
    }
    
    void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    void setFotoStudio(FotoStudio fotoStudio) {
        this.fotoStudio = fotoStudio;
    }
    
    void setService(SellService service) {
        this.service = service;
    }

    void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
}
