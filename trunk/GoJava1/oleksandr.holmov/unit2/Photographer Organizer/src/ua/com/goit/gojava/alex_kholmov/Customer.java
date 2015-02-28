/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Customer {
    private Contact contact;
    private String additionalInfo;
    private int customerId;

    public Customer(Contact contact, String additionalInfo) {
        this.contact = contact;
        this.additionalInfo = additionalInfo;
    }

    int getCustomerId() {
        return customerId;
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId;
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
