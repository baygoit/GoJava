/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class SellService {
    private PackageFotos fotos;
    private String describe;
    private int price;
    private int serviceTime; //hours

    PackageFotos getFotos() {
        return fotos;
    }
    void setFotos(PackageFotos fotos) {
        this.fotos = fotos;
    }
    String getDescribe() {
        return describe;
    }
    void setDescribe(String describe) {
        this.describe = describe;
    }
    int getPrice() {
        return price;
    }
    void setPrice(int price) {
        this.price = price;
    }
    int getServiceTime() {
        return serviceTime;
    }
    void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    
    
}
