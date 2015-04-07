/**
 * 
 */
package alexkholmov.organizer.logic;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author SASH
 *
 */
@Entity
@Table(name="studio")
public class FotoStudio {
    @Transient
    public final static String TYPE = "S";
    
    @Id
    @GeneratedValue
    @Column(name="stud_id")
    private int studioId;
    
    @Column(name="stud_name")
    private String name;
    
    @Column(name="stud_address")
    private String address;
    
    @Column(name="stud_phone")
    private String phone;
    
    @Column(name="stud_info")
    private String additionalInfo;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="studio")
    private List<Reserve> reserves;

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
     * @return the reserves
     */
    public List<Reserve> getReserves() {
        return reserves;
    }

    /**
     * @param reserves the reserves to set
     */
    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }
    
}
