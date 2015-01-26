/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class PackageFotos {
    private int amountFotos;
    private int timeEditingFoto; //hours
    private int timeReserve;     //percents
    
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
        int editAllFotos = timeEditingFoto * amountFotos;
        return editAllFotos + ((editAllFotos * timeReserve) / 100);
    }
}
