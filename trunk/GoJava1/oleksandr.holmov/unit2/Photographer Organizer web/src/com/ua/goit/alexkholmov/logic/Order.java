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
    private Photography photography;
    private Schedule schedule;
    private String additionalInfo;
    private int orderId;
    
    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * @return the fotoStudio
     */
    public FotoStudio getFotoStudio() {
        return fotoStudio;
    }
    /**
     * @param fotoStudio the fotoStudio to set
     */
    public void setFotoStudio(FotoStudio fotoStudio) {
        this.fotoStudio = fotoStudio;
    }
    /**
     * @return the photography
     */
    public Photography getPhotography() {
        return photography;
    }
    /**
     * @param photography the photography to set
     */
    public void setPhotography(Photography photography) {
        this.photography = photography;
    }
    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }
    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    /**
     * @return the additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    /**
     * @param additionalInfo the additionalInfo to set
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }
    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
}
