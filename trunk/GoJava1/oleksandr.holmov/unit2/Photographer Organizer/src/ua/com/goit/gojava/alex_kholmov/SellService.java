/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;

/**
 * @author SASH
 *
 */
public class SellService implements ShowInfo{
    //ArrayList<PackageFotos> packagesFotos = new ArrayList<PackageFotos>();
    private ListOfFotoPackages listOfFotoPackages;
    private String describe;
    private int price;
    private int serviceTime; //hours

    public SellService(String describe, ListOfFotoPackages listOfFotoPackages, int price, int serviceTime) {
        this.describe = describe;
        this.price = price;
        this.serviceTime = serviceTime;
        this.listOfFotoPackages = listOfFotoPackages;
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

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        System.out.println("Описание заказанного пакета услуг: " + describe);
        System.out.println("Описание фотографий в услуге:");
        listOfFotoPackages.displayInfo();
        System.out.println("Цена пакета: " + price);
        System.out.println("Время: " + serviceTime);
    }
    
}
