/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;

/**
 * @author SASH
 *
 */
public class WorkWithFotos {
    ArrayList<PackageFotos> allFotos = new ArrayList<PackageFotos>();

    void addPackage(PackageFotos pFotos) {
        allFotos.add(pFotos);
    }
    
    void removePackage(PackageFotos pFotos) {
        allFotos.remove(pFotos);
    }
    
    //return in hours
    int timeEditingFotosInPackage() {
        int hoursToEditAllPhotos = 0;
        for (PackageFotos pFotos : allFotos) {
            int allTime = pFotos.getTimeEditingFoto() * pFotos.getAmountFotos();
            int editAllFotos = allTime
                    + ((allTime * pFotos.getTimeReserve()) / 100);
            hoursToEditAllPhotos += editAllFotos / 60;
        }
        return hoursToEditAllPhotos;
    }
}
