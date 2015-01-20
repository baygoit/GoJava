/**
 * 
 */
package test.solidcalc.menu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SASH
 *
 */
public class MaterialsMenu extends Menu {
    
    public Map<Integer, String> menuData = new HashMap<Integer, String>();
    
    public MaterialsMenu() {
        menuData.put(1, "аустенитная сталь");
        menuData.put(2, "перлитная сталь");
        menuData.put(3, "углеродистая сталь");
    }
}
