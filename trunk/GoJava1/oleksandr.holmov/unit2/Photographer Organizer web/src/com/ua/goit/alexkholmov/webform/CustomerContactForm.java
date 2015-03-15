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
    private String name;
    private String address;
    private String phone;
    private String info;
    private Collection<Customer> customers;

    public void initFromCustomer(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.info = customer.getAdditionalInfo();
    }
    
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
