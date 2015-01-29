/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class PackageFotos {
    private String describePackage;
    private int amountFotos;
    private int timeEditingFoto; //minutes
    private int timeReserve;     //percents

    public PackageFotos(int amountFotos, int timeEditingFoto, int timeReserve) {
        this.amountFotos = amountFotos;
        this.timeEditingFoto = timeEditingFoto;
        this.timeReserve = timeReserve;
    }
    
    
    String getDescribePackage() {
        return describePackage;
    }

    void setDescribePackage(String describePackage) {
        this.describePackage = describePackage;
    }

    int getAmountFotos() {
        return amountFotos;
    }
    
    void setAmountFotos(int amountFotos) {
        this.amountFotos = amountFotos;
    }
    
    int getTimeEditingFoto() {
        return timeEditingFoto;
    }
    
    void setTimeEditingFoto(int timeEditingFoto) {
        this.timeEditingFoto = timeEditingFoto;
    }
    
    int getTimeReserve() {
        return timeReserve;
    }
    
    void setTimeReserve(int timeReserve) {
        this.timeReserve = timeReserve;
    }
    //return in hours
    public int timeEditingAllFotos() {
        int allTime = timeEditingFoto * amountFotos;
        int editAllFotos = allTime + ((allTime * timeReserve) / 100);
        return editAllFotos / 60;
    }
}
