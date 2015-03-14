/**
 * 
 */
package com.ua.goit.alexkholmov.webform;

import java.util.Collection;

import com.ua.goit.alexkholmov.logic.FotoStudio;

/**
 * @author SASH
 *
 */
public class StudioContactForm {
    
    private int studioId;
    private int contactId;
    private String name;
    private String address;
    private String info;
    private Collection<FotoStudio> studios;
    /**
     * @return the studioId
     */
    public int getStudioId() {
        return studioId;
    }
    /**
     * @param studioId the studioId to set
     */
    public void setStudioId(int studioId) {
        this.studioId = studioId;
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
     * @return the studios
     */
    public Collection<FotoStudio> getStudios() {
        return studios;
    }
    /**
     * @param studios the studios to set
     */
    public void setStudios(Collection<FotoStudio> studios) {
        this.studios = studios;
    }
    
}
