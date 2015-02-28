/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Contact {
    private String name;
    private String address;
    private String phone;
    
    public Contact(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    String getAddress() {
        return address;
    }
    void setAddress(String address) {
        this.address = address;
    }
    String getPhone() {
        return phone;
    }
    void setPhone(String phone) {
        this.phone = phone;
    }

}
