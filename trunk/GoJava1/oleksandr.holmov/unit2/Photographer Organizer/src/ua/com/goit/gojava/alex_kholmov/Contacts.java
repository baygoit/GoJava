/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Contacts implements ShowInfo{
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

    public void displayInfo() {
        System.out.println("Имя или наименование: " + name);
        System.out.println("Адрес: " + address);
        System.out.println("Телефон: " + phone);
    }
}
