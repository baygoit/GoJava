/**
 * 
 */
package com.ua.goit.alexkholmov.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SASH
 *
 */
public class WorkWithFotos {
    List<PackageFotos> allFotos = new ArrayList<PackageFotos>();

    public void addPackage(PackageFotos pFotos) {
        allFotos.add(pFotos);
    }
    
    public void removePackage(PackageFotos pFotos) {
        allFotos.remove(pFotos);
    }
    
    //return in hours
    int timeEditingFotosInPackage() throws Exception {
        if (allFotos.isEmpty()) {
            throw new Exception("You shoud add at least one package!");
        } else {
            int hoursToEditAllPhotos = 0;
            for (PackageFotos pFotos : allFotos) {
                hoursToEditAllPhotos += pFotos.timeEditAllFotos() / 60;
            }
            return hoursToEditAllPhotos;
        }
    }
}
