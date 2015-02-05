/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Customer implements ShowInfo{
    private Contacts contacts;
    private String additionalInfo;

    public Customer(Contacts contacts, String additionalInfo) {
        // TODO Auto-generated constructor stub
        this.contacts = contacts;
        this.additionalInfo = additionalInfo;
    }
    
    Contacts getContacts() {
        return contacts;
    }
    
    void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
    
    String getAdditionalInfo() {
        return additionalInfo;
    }
    
    void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    public void displayInfo() {
        contacts.displayInfo();
        System.out.println(additionalInfo);
    }
}
