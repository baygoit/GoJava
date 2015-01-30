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
    static int TIME_WORKING_IN_DAY = 4; //hours
    
    int amountDays;
    
    ArrayList<PackageFotos> packagesFotos = new ArrayList<PackageFotos>();
    private String describe;
    private int price;
    private int serviceTime; //hours

    public SellService(String describe, int price, int serviceTime) {
        this.describe = describe;
        this.price = price;
        this.serviceTime = serviceTime;
    }
    
    void addPackage(PackageFotos pFotos) {
        packagesFotos.add(pFotos);
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

    void daysEditFotosInService() {
        int timeSum = 0;
        for (PackageFotos pf : packagesFotos) {
            timeSum += pf.timeEditingAllFotos();
        }
        amountDays = timeSum / TIME_WORKING_IN_DAY;
    }
    
}
