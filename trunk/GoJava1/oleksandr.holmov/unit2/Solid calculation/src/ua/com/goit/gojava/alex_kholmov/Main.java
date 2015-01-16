/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author Alex Kholmovs
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainMenu myMenu = new MainMenu();
        myMenu.drawMenu();
        int menuPoint = myMenu.menuPoint();
        myMenu.chooseResPoint(menuPoint);
    }

}
