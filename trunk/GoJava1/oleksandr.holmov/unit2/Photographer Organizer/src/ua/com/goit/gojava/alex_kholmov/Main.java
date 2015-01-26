/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

/**
 * @author SASH
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FotoStudio myStudio = new FotoStudio();
        myStudio.setName("studio Name");
        myStudio.setAddress("123 Street, fl 45");
        myStudio.setPhone(456789);
        myStudio.setReserveDate(2015, 3, 14, 12, 15);
        System.out.println(myStudio.getName());
        System.out.println(myStudio.getAddress());
        System.out.println(myStudio.getPhone());
        System.out.println(myStudio.displayReserveDate());
        System.out.println();
    }

}
