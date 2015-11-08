/**
 * 
 */
package alexkholmov.organizer.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SASH
 *
 */
@Entity
@Table(name="photography")
public class Photography {
    
    @Id
    @GeneratedValue
    @Column(name="phot_id")
    private int photographyId;
    
    @Column(name="phot_price")
    private int price;
    
    @Column(name="phot_time")
    private int photographyTime; //hours
    
    @Column(name="phot_info")
    private String description;    
    
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
