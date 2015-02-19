/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author SASH
 *
 */
public class TestPackageFotos {
    private PackageFotos pFotos = new PackageFotos("pack1", 250, 15, 10, 1);

    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.PackageFotos#timeEditAllFoto()}.
     */
    @Test
    public void testTimeEditAllFoto() {
        int res = pFotos.timeEditAllFoto();
        assertEquals("Error", 4125, res);
    }

}
