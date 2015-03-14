/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

import java.io.Serializable;

/**
 * @author SASH
 *
 */
public class PackageFotos implements Serializable{
    private String packageDescription;
    private int amountFotos;
    private int timeEditingOneFoto;     //minutes
    private int percentReserveTime;     //percents
    private int packageId;

    public PackageFotos() {

    }
    
    public PackageFotos(String packageDescription, int amountFotos, int timeEditingOneFoto, int percentReserveTime, int packageId) {
        this.packageDescription = packageDescription;
        this.amountFotos = amountFotos;
        this.timeEditingOneFoto = timeEditingOneFoto;
        this.percentReserveTime = percentReserveTime;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amountFotos;
        result = prime * result
                + ((packageDescription == null) ? 0 : packageDescription.hashCode());
        result = prime * result + timeEditingOneFoto;
        result = prime * result + percentReserveTime;
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
        if (packageDescription == null) {
            if (other.packageDescription != null)
                return false;
        } else if (!packageDescription.equals(other.packageDescription))
            return false;
        if (timeEditingOneFoto != other.timeEditingOneFoto)
            return false;
        if (percentReserveTime != other.percentReserveTime)
            return false;
        return true;
    }

    

    int getPackageId() {
        return packageId;
    }

    void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    String getDescribePackage() {
        return packageDescription;
    }

    void setDescribePackage(String packageDescription) {
        this.packageDescription = packageDescription;
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
    
    void setTimeEditingFoto(int timeEditingOneFoto) {
        this.timeEditingOneFoto = timeEditingOneFoto;
    }
    
    int getPercentReserve() {
        return percentReserveTime;
    }

    void setPercentReserve(int percentReserveTime) {
        this.percentReserveTime = percentReserveTime;
    }

    //return time in minutes
    public int timeEditAllFotos() {
        int allTime = amountFotos * timeEditingOneFoto;
        return allTime + ((allTime * percentReserveTime) / 100);
    }

}
