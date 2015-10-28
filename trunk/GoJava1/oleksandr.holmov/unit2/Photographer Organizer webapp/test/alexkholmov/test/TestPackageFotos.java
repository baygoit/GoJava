/**
 * 
 */
package alexkholmov.test;

import static org.junit.Assert.*;

import org.junit.Test;

import alexkholmov.organizer.logic.PackageFotos;

/**
 * @author SASH
 *
 */
public class TestPackageFotos {
    private PackageFotos pFotos = new PackageFotos(250, 15, 10);

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.PackageFotos#timeEditAllFotos()}.
     */
    @Test
    public void testTimeEditAllFoto() {
        int res = pFotos.timeEditAllFotos();
        assertEquals("Error", 4125, res);
    }

}
