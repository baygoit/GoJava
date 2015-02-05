/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;

/**
 * @author SASH
 *
 */
public class ListOfFotoPackages implements ShowInfo{
    ArrayList<PackageFotos> allFotos = new ArrayList<PackageFotos>();
    
    void addPackage(PackageFotos pFotos) {
        allFotos.add(pFotos);
    }
    
    void removePackage(PackageFotos pFotos) {
        allFotos.remove(pFotos);
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        for (PackageFotos packageFotos : allFotos) {
            packageFotos.displayInfo();
        }
    }
    
    
}
