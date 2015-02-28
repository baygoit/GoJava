/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SASH
 *
 */
public class FotoStudio {
    private Contact contact;
    private String additionalInfo;
    private int studioId;
    List<Reserve> reservs = new ArrayList<Reserve>();

    public FotoStudio(Contact contact, String additionalInfo) {
        this.contact = contact;
        this.additionalInfo = additionalInfo;
    }

    int getStudioId() {
        return studioId;
    }

    void setStudioId(int studioId) {
        this.studioId = studioId;
    }
    
    void addReserv(Reserve reserv) {
        reservs.add(reserv);
    }
    
    void removeReserv(Reserve reserv) {
        reservs.remove(reserv);
    }

    Contact getContacts() {
        return contact;
    }

    void setContacts(Contact contact) {
        this.contact = contact;
    }

    String getAdditionalInfo() {
        return additionalInfo;
    }

    void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}
