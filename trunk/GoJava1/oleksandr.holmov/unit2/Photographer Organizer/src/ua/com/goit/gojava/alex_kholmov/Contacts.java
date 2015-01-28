/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Contacts {
    private String name;
    private String address;
    private int phone;

    public Contacts(String name, String address, int phone) {
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
    int getPhone() {
        return phone;
    }
    void setPhone(int phone) {
        this.phone = phone;
    }
    
}
