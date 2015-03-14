/**
 * 
 */
package com.ua.goit.alexkholmov.webform;

import java.util.Collection;

import com.ua.goit.alexkholmov.logic.Customer;

/**
 * @author SASH
 *
 */
public class CustomerContactForm {
    
    private int customerId;
    private int contactId;
    private String name;
    private String address;
    private String info;
    private Collection<Customer> customers;
    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }
    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    /**
     * @return the contactId
     */
    public int getContactId() {
        return contactId;
    }
    /**
     * @param contactId the contactId to set
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }
    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }
    /**
     * @return the customers
     */
    public Collection<Customer> getCustomers() {
        return customers;
    }
    /**
     * @param customers the customers to set
     */
    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
