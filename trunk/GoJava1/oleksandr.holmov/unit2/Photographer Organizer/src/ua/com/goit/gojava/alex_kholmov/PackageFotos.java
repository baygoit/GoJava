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
    private int timeEditingFoto; //minutes
    private int timeReserve;     //percents
    
    int getAmountFotos() {
        return amountFotos;
    }
    void setAmountFotos(int amountFotos) {
        this.amountFotos = amountFotos;
    }
    float getTimeEditingFoto() {
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
    public float timeEditingAllFotos() {
        float editAllFotos = timeEditingFoto * amountFotos;
        return editAllFotos + ((editAllFotos * timeReserve) / 100);
    }
}
