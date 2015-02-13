/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author SASH
 *
 */
public class Main {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
      PackageFotos pFotos1 = new PackageFotos("stantard", 250, 15, 10);
      PackageFotos pFotos2 = new PackageFotos("redact", 40, 35, 15);
      SaveObjectToFile saveObjectToFile = new SaveObjectToFile();
      saveObjectToFile.saveObject(pFotos1, "package1.out");
      saveObjectToFile.saveObject(pFotos2, "package2.out");
      WorkWithFotos workWithFotos = new WorkWithFotos();
      workWithFotos.addPackage(pFotos1);
      workWithFotos.addPackage(pFotos2);
      System.out.println("time to edit all fotos in package: " + workWithFotos.timeEditingFotosInPackage() + " hours");
      
//      Schedule schedule = new Schedule();
//      schedule.setWorkWithFotos(workWithFotos);
//      schedule.setDeadline(2015, 2, 4);
//      schedule.setStartWork(2015, 1, 13);
//      schedule.calcEndWork();
//      System.out.println("days to edit: " + schedule.getAmountDays());
      //schedule.isOutOfDeadline();
      //schedule.displayInfo();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
//        Calendar cal = Calendar.getInstance();
//        cal.set(2015, 1, 14);
//        System.out.println("Date: " + dateFormat.format(cal.getTime()));
//        System.out.println("Day: " + cal.get(Calendar.DAY_OF_WEEK));
        
//        Reserve my1res = new Reserve(3);
//        Reserve my2res = new Reserve(4);
//        my2res.setReserveDate(2015, 1, 12, 12, 40);
//        Contacts contactsCustomer = new Contacts("Customer", "123, some street", "+345 777 90 90");
//        Contacts contactsStudio = new Contacts("Studio", "345 some street, 23", "+456 555 77 66");
//        Customer myCustomer = new Customer(contactsCustomer, "some add info");
//        FotoStudio myFotoStudio = new FotoStudio(contactsStudio, "some info for stodio");
//        myFotoStudio.addReserv(my1res);
//        myFotoStudio.addReserv(my2res);
//        myFotoStudio.displayInfo();
//        myFotoStudio.removeReserv(my2res);
//        myFotoStudio.displayInfo();
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
