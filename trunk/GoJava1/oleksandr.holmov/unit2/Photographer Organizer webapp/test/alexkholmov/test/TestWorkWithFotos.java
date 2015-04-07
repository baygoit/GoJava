/**
 * 
 */
package alexkholmov.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import alexkholmov.organizer.logic.PackageFotos;
import alexkholmov.organizer.logic.WorkWithFotos;
/**
 * @author SASH
 *
 */
public class TestWorkWithFotos {
    private PackageFotos pFotos1 = new PackageFotos(250, 15, 10);
    private PackageFotos pFotos2 = new PackageFotos(45, 40, 15);
    
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
        assertEquals("Error in adding package", 2, workWithFotos.amountPackage());
    }
    
    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.WorkWithFotos#removePackage(ua.com.goit.gojava.alex_kholmov.PackageFotos)}.
     */
    @Test
    public void testRemovePackage() {
        workWithFotos.removePackage(pFotos1);
        int count = 0;
        for (PackageFotos pf : workWithFotos.getAllFotos()) {
            count++;
        }
        assertEquals("Error in removing package", 1, count);
    }

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.WorkWithFotos#timeEditingFotosInPackage()}.
     * @throws Exception 
     */
    @Test
    public void testTimeEditingFotosInPackage() throws Exception {
        int res = workWithFotos.timeEditingFotosInPackage();
        assertEquals("Error in editing time", 102, res);
    }
    
    @Test(expected = Exception.class)
    public void testException() throws Exception {
        workWithFotos.removePackage(pFotos1);
        workWithFotos.removePackage(pFotos2);
        workWithFotos.timeEditingFotosInPackage();
    }

}
