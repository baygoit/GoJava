/**
 * 
 */
package com.ua.goit.alexkholmov.logic;


/**
 * @author SASH
 *
 */
public class PackageFotos{
    
    private String packageDescription;
    private int amountFotos;
    private int timeEditingOneFoto;     //minutes
    private int percentReserveTime;     //percents
    private int packageId;

    public PackageFotos() {

    }
    
    public PackageFotos(int amountFotos, int timeEditingOneFoto, int percentReserveTime) {
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
    
    /**
     * @return the packageDescription
     */
    public String getPackageDescription() {
        return packageDescription;
    }

    /**
     * @param packageDescription the packageDescription to set
     */
    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    /**
     * @return the amountFotos
     */
    public int getAmountFotos() {
        return amountFotos;
    }

    /**
     * @param amountFotos the amountFotos to set
     */
    public void setAmountFotos(int amountFotos) {
        this.amountFotos = amountFotos;
    }

    /**
     * @return the timeEditingOneFoto
     */
    public int getTimeEditingOneFoto() {
        return timeEditingOneFoto;
    }

    /**
     * @param timeEditingOneFoto the timeEditingOneFoto to set
     */
    public void setTimeEditingOneFoto(int timeEditingOneFoto) {
        this.timeEditingOneFoto = timeEditingOneFoto;
    }

    /**
     * @return the percentReserveTime
     */
    public int getPercentReserveTime() {
        return percentReserveTime;
    }

    /**
     * @param percentReserveTime the percentReserveTime to set
     */
    public void setPercentReserveTime(int percentReserveTime) {
        this.percentReserveTime = percentReserveTime;
    }

    /**
     * @return the packageId
     */
    public int getPackageId() {
        return packageId;
    }

    /**
     * @param packageId the packageId to set
     */
    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    //return time in minutes
    public int timeEditAllFotos() {
        int allTime = amountFotos * timeEditingOneFoto;
        return allTime + ((allTime * percentReserveTime) / 100);
    }

}
