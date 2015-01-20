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
public class MainMenu extends Menu {
    
    public Map<Integer, String> menuData = new HashMap<Integer, String>();
    
    public MainMenu() {
        menuData.put(0, "Выход");
        menuData.put(1, "Расчет стяжных шпилек");
        menuData.put(2, "Расчет резьбы");
        menuData.put(3, "Расчет подшипников");
    }
   
}
