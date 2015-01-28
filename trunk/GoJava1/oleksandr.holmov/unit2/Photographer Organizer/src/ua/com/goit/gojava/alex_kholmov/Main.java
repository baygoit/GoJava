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
        FotoStudio myStudio = new FotoStudio("some studio", "333 street, room 12", 5555555);
        myStudio.setReserveDate(2015, 2, 14, 14, 50);
        System.out.println(myStudio.getName());
        System.out.println(myStudio.getAddress());
        System.out.println(myStudio.getPhone());
        System.out.println(myStudio.displayReserveDate());
        System.out.println();
        
        PackageFotos pFotos1 = new PackageFotos(25, 10, 5);
        PackageFotos pFotos2 = new PackageFotos(15, 20, 10);
        
        SellService service = new SellService("type of fotoset package", 1500, 2);
        service.addPackage(pFotos1);
        service.addPackage(pFotos2);
        
        for (PackageFotos pf : service.packagesFotos) {
            System.out.print("\n" + pf.getAmountFotos());
        }
        //System.out.println("time to edit all fotos in first package " + pFotos1.timeEditingAllFotos());
        //System.out.println("time to edit all fotos in second package " + pFotos2.timeEditingAllFotos());
    }

}
