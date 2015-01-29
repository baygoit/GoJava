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
    private String phone;

    public Contacts(String name, String address, String phone) {
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

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }
}
