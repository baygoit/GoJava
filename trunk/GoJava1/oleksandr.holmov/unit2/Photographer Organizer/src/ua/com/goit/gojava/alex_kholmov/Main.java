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
        Reserve my1res = new Reserve(3);
        Reserve my2res = new Reserve(4);
        my2res.setReserveDate(2015, 1, 12, 12, 40);
        Contacts contactsCustomer = new Contacts("Customer", "123, some street", "+345 777 90 90");
        Contacts contactsStudio = new Contacts("Studio", "345 some street, 23", "+456 555 77 66");
        Customer myCustomer = new Customer(contactsCustomer, "some add info");
        FotoStudio myFotoStudio = new FotoStudio(contactsStudio, "some info for stodio");
        myFotoStudio.addReserv(my1res);
        myFotoStudio.addReserv(my2res);
        myFotoStudio.displayInfo();
        myFotoStudio.removeReserv(my2res);
        myFotoStudio.displayInfo();
        //myCustomer.displayInfo();
        //my1res.displayReserveDateTime();
//        PackageFotos pFotos1 = new PackageFotos(200, 10, 10);
//        PackageFotos pFotos2 = new PackageFotos(35, 20, 15);
//        
//        SellService service = new SellService("type of fotoset package", 1500, 2);
//        service.addPackage(pFotos1);
//        service.addPackage(pFotos2);
//        service.daysEditFotosInService();
//        System.out.println("Количество дней дял работы: " + service.amountDays);
//        
//        Order myOrder = new Order();
//        myOrder.setCustomer(myCustomer);
//        myOrder.setFotoStudio(myStudio);
//        myOrder.setDeadline(2015, 3, 22);
//        myOrder.setStartWork(2015, 3, 15);
//        myOrder.calcEndWork(service.amountDays);
//        myOrder.displayOrder();
//        myOrder.checkWorkDays();
    }

}
