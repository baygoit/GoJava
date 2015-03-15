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
    private String name;
    private String address;
    private String phone;
    private String info;
    private Collection<FotoStudio> studios;
    
    public void iniFromFotostudio(FotoStudio studio) {
        this.studioId = studio.getStudioId();
        this.name = studio.getName();
        this.address = studio.getAddress();
        this.phone = studio.getPhone();
        this.info = studio.getAdditionalInfo();
    }
    
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
