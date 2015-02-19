/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;

/**
 * @author SASH
 *
 */
public class SellService {
    private String describe;
    private int price;
    private int serviceTime; //hours

    public SellService(String describe, int price, int serviceTime) {
        this.describe = describe;
        this.price = price;
        this.serviceTime = serviceTime;
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
