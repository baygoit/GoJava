/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
//change naming
public class Photography {
    private String description;
    private int price;
    private int photographyTime; //hours

    public Photography(String description, int price, int photographyTime) {
        this.description = description;
        this.price = price;
        this.photographyTime = photographyTime;
    }
    
    String getDescribe() {
        return description;
    }
    void setDescribe(String description) {
        this.description = description;
    }
    int getPrice() {
        return price;
    }
    void setPrice(int price) {
        this.price = price;
    }
    int getServiceTime() {
        return photographyTime;
    }
    void setServiceTime(int photographyTime) {
        this.photographyTime = photographyTime;
    }
    
}
