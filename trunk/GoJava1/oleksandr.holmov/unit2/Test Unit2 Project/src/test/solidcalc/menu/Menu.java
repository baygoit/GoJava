/**
 * 
 */
package test.solidcalc.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SASH
 *
 */
public class Menu {
    
    public Map<Integer, String> menuData = new HashMap<Integer, String>();
 
    
    public void drawMenu() {
        for (Map.Entry entry : menuData.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
    
    public int getMenuPoint() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите пункт меню: ");
        if (scan.hasNextInt()) {
            return scan.nextInt();
        } else {
            System.out.print("Введите число");
            return 0;
        }
    }
}
