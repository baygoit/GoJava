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
public class TestWorkWithFotos {
    private PackageFotos pFotos1 = new PackageFotos("pack1", 250, 15, 10);
    private PackageFotos pFotos2 = new PackageFotos("pack2", 45, 40, 15);
    
    private WorkWithFotos workWithFotos = new WorkWithFotos();
    
    @Before
    public void add() {
        workWithFotos.addPackage(pFotos1);
        workWithFotos.addPackage(pFotos2);
    }
    
    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.WorkWithFotos#addPackage(ua.com.goit.gojava.alex_kholmov.PackageFotos)}.
     */
    @Test
    public void testAddPackage() {
        //fail("Not yet implemented"); // TODO
        int count = 0;
        for (PackageFotos pf : workWithFotos.allFotos) {
            count++;
        }
        assertEquals("Error", 2, count);
    }
    
    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.WorkWithFotos#removePackage(ua.com.goit.gojava.alex_kholmov.PackageFotos)}.
     */
    @Test
    public void testRemovePackage() {
        //fail("Not yet implemented"); // TODO
        workWithFotos.removePackage(pFotos1);
        int count = 0;
        for (PackageFotos pf : workWithFotos.allFotos) {
            count++;
        }
        assertEquals("Error", 1, count);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.WorkWithFotos#timeEditingFotosInPackage()}.
     * @throws Exception 
     */
    @Test
    public void testTimeEditingFotosInPackage() throws Exception {
        //fail("Not yet implemented"); // TODO
        int res = workWithFotos.timeEditingFotosInPackage();
        assertEquals("Error", 102, res);
    }
    
    @Test(expected = Exception.class)
    public void testException() throws Exception {
        workWithFotos.removePackage(pFotos1);
        workWithFotos.removePackage(pFotos2);
        workWithFotos.timeEditingFotosInPackage();
    }

}
