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
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amountFotos;
        result = prime * result
                + ((describePackage == null) ? 0 : describePackage.hashCode());
        result = prime * result + timeEditingFoto;
        result = prime * result + timeReserve;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PackageFotos other = (PackageFotos) obj;
        if (amountFotos != other.amountFotos)
            return false;
        if (describePackage == null) {
            if (other.describePackage != null)
                return false;
        } else if (!describePackage.equals(other.describePackage))
            return false;
        if (timeEditingFoto != other.timeEditingFoto)
            return false;
        if (timeReserve != other.timeReserve)
            return false;
        return true;
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
