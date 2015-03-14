/**
 * 
 */
package com.ua.goit.alexkholmov.logic;


/**
 * @author SASH
 *
 */
public class Order {
    private Customer customer;
    private FotoStudio fotoStudio;
    private Photography service;
    private Schedule schedule;
    private int orderId;

    public Order(Customer customer, FotoStudio fotoStudio, Photography service, Schedule schedule) {
        this.customer = customer;
        this.fotoStudio = fotoStudio;
        this.service = service;
        this.schedule = schedule;
    }

    int getId() {
        return orderId;
    }
    
    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    void setFotoStudio(FotoStudio fotoStudio) {
        this.fotoStudio = fotoStudio;
    }
    
    void setService(Photography service) {
        this.service = service;
    }

    void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
}
