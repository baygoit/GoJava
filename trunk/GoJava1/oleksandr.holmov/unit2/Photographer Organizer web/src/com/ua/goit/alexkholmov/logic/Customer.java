/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author SASH
 *
 */
public class Customer {
    public final static String TYPE = "C"; 
    
    private int customerId;
    private String name;
    private String address;
    private String phone;
    private String additionalInfo;

    public Customer() {
        // default
    }
    
    public Customer(ResultSet rs) throws SQLException {
        this.customerId = rs.getInt("cust_id");
        this.name = rs.getString("cust_name");
        this.address = rs.getString("cust_address");
        this.phone = rs.getString("cust_phone");
        this.additionalInfo = rs.getString("cust_info");
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

}
