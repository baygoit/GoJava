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
        FotoStudio myStudio = new FotoStudio("some studio", "333 street, room 12", "+38093 666 78 89");
        myStudio.setReserveDate(2015, 2, 14, 14, 50);
        myStudio.setReserveTime(3);
        myStudio.printInfo();
        myStudio.displayReserveDateTime();
        System.out.println();
        Customer myCustomer = new Customer("vasya i petya", "34 stree, house 12", "+38096 888 89 65");
        myCustomer.printInfo();
        
        PackageFotos pFotos1 = new PackageFotos(25, 10, 5);
        PackageFotos pFotos2 = new PackageFotos(15, 20, 10);
        
        SellService service = new SellService("type of fotoset package", 1500, 2);
        service.addPackage(pFotos1);
        service.addPackage(pFotos2);
        
        Order myOrder = new Order();
        myOrder.setDeadline(2015, 3, 22);
        myOrder.setStartWork(2015, 3, 12);
        int time = myOrder.timeEditFotosInService(service);
        myOrder.daysEditFotosInService(time);
        myOrder.setEndWork();
        myOrder.displayOrder();
        //System.out.println("time to edit all fotos in first package " + pFotos1.timeEditingAllFotos());
        //System.out.println("time to edit all fotos in second package " + pFotos2.timeEditingAllFotos());
    }

}
