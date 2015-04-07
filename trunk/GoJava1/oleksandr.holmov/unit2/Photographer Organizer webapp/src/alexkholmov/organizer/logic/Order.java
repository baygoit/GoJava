/**
 * 
 */
package alexkholmov.organizer.logic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * @author SASH
 *
 */
@Entity
@Table(name="order")
public class Order {
    
    @Id
    @GeneratedValue
    @Column(name="ord_id")
    private int orderId;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private FotoStudio fotoStudio;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn    
    private Photography photography;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn    
    private Schedule schedule;
    
    @Column(name="ord_info")
    private String additionalInfo;
    
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
