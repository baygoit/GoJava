/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.io.Serializable;

/**
 * @author SASH
 *
 */
public class PackageFotos implements ShowInfo, Serializable{
    private String describePackage;
    private int amountFotos;
    private int timeEditingFoto; //minutes
    private int percentReserve;  //percents

    public PackageFotos(String describePackage, int amountFotos, int timeEditingFoto, int percentReserve) {
        this.describePackage = describePackage;
        this.amountFotos = amountFotos;
        this.timeEditingFoto = timeEditingFoto;
        this.percentReserve = percentReserve;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amountFotos;
        result = prime * result
                + ((describePackage == null) ? 0 : describePackage.hashCode());
        result = prime * result + timeEditingFoto;
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
        if (timeEditingFoto != other.timeEditingFoto)
            return false;
        if (percentReserve != other.percentReserve)
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
        return percentReserve;
    }
    
    void setTimeReserve(int timeReserve) {
        this.percentReserve = timeReserve;
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        System.out.println("Описание пакета фотографий: " + describePackage);
        System.out.println("Количество фотографий в пакете: " + amountFotos);
        System.out.println("Время на редактирование одной фотографии: " + timeEditingFoto);
        System.out.println("Резерв времени на редактирование всего пакета в %: " + percentReserve);
    }
}
