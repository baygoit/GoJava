/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author SASH
 *
 */
public class TestOrder {
    private PackageFotos pFotos1 = new PackageFotos(200, 10, 10);
    private PackageFotos pFotos2 = new PackageFotos(35, 20, 15);
    
    private SellService sellService = new SellService("test service", 1000, 4);
    
    private Order order = new Order();
    
    @Before
    public void add() {
        sellService.addPackage(pFotos1);
        sellService.addPackage(pFotos2);
        sellService.daysEditFotosInService();
        
        order.setDeadline(2015, 3, 22);
        order.setStartWork(2015, 3, 20);
    }
    
    @Test
    public void testCalcEndWork() {
        int amountDays = sellService.amountDays;
        order.calcEndWork(amountDays);
    }
    
}
