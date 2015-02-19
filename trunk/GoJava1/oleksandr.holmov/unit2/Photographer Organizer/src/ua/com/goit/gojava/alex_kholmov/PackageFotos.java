/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.io.Serializable;

/**
 * @author SASH
 *
 */
public class PackageFotos implements Serializable{
    private String describePackage;
    private int amountFotos;
    private int timeEditingOneFoto; //minutes
    private int percentReserve;     //percents
    private static int packageId;

    public PackageFotos() {
        // TODO Auto-generated constructor stub
    }
    
    public PackageFotos(String describePackage, int amountFotos, int timeEditingFoto, int percentReserve, int packageId) {
        this.describePackage = describePackage;
        this.amountFotos = amountFotos;
        this.timeEditingOneFoto = timeEditingFoto;
        this.percentReserve = percentReserve;
        this.packageId = packageId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amountFotos;
        result = prime * result
                + ((describePackage == null) ? 0 : describePackage.hashCode());
        result = prime * result + timeEditingOneFoto;
        result = prime * result + percentReserve;
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
        if (timeEditingOneFoto != other.timeEditingOneFoto)
            return false;
        if (percentReserve != other.percentReserve)
            return false;
        return true;
    }

    

    static int getPackageId() {
        return packageId;
    }

    static void setPackageId(int packageId) {
        PackageFotos.packageId = packageId;
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
        return timeEditingOneFoto;
    }
    
    void setTimeEditingFoto(int timeEditingFoto) {
        this.timeEditingOneFoto = timeEditingFoto;
    }
    
    int getPercentReserve() {
        return percentReserve;
    }

    void setPercentReserve(int percentReserve) {
        this.percentReserve = percentReserve;
    }

    //return time in minutes
    int timeEditAllFoto() {
        int allTime = amountFotos * timeEditingOneFoto;
        return allTime + ((allTime * percentReserve) / 100);
    }

}
