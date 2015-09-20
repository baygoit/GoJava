/**
 * 
 */
package alexkholmov.organizer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SASH
 *
 */
public class WorkWithFotos {
    
    private List<PackageFotos> allFotos = new ArrayList<PackageFotos>();

    public void addPackage(PackageFotos pFotos) {
        allFotos.add(pFotos);
    }
    
    public void removePackage(PackageFotos pFotos) {
        allFotos.remove(pFotos);
    }
    
    public int amountPackage() {
        return allFotos.size();
    }
    
    /**
     * @return the allFotos
     */
    public List<PackageFotos> getAllFotos() {
        return allFotos;
    }

    /**
     * @param allFotos the allFotos to set
     */
    public void setAllFotos(List<PackageFotos> allFotos) {
        this.allFotos = allFotos;
    }

    //return in hours
    public int timeEditingFotosInPackage() throws Exception {
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
