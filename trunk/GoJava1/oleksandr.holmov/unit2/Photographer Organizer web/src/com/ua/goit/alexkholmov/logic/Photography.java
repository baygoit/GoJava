/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

/**
 * @author SASH
 *
 */
public class Photography {

    private String description;
    private int price;
    private int photographyTime; //hours
    private int photographyId;
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @return the photographyTime
     */
    public int getPhotographyTime() {
        return photographyTime;
    }
    /**
     * @param photographyTime the photographyTime to set
     */
    public void setPhotographyTime(int photographyTime) {
        this.photographyTime = photographyTime;
    }
    /**
     * @return the photographyId
     */
    public int getPhotographyId() {
        return photographyId;
    }
    /**
     * @param photographyId the photographyId to set
     */
    public void setPhotographyId(int photographyId) {
        this.photographyId = photographyId;
    }

}
