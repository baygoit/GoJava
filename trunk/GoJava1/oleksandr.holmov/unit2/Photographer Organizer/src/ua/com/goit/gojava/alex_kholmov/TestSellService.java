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
public class TestSellService {
    private PackageFotos pFotos1 = new PackageFotos(200, 10, 10);
    private PackageFotos pFotos2 = new PackageFotos(35, 20, 15);

    private SellService sellService = new SellService("test service", 1000, 4);

    @Before
    public void add() {
        sellService.addPackage(pFotos1);
        sellService.addPackage(pFotos2);
        sellService.daysEditFotosInService();
    }
    
    @Test
    public void testAdd() {
        int count = 0;
        for (PackageFotos pf : sellService.packagesFotos) {
            assertNotNull(pf);
            count++;
        }
        assertEquals("Error", 2, 2);
    }

    @Test
    public void testDaysEditFotosInService() {
        assertEquals("Error", 12, sellService.amountDays);
    }
}
