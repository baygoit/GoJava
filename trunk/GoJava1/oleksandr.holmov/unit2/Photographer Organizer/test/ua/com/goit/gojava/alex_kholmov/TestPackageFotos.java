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
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.PackageFotos#timeEditAllFotos()}.
     */
    @Test
    public void testTimeEditAllFoto() {
        int res = pFotos.timeEditAllFotos();
        assertEquals("Error", 4125, res);
    }

}
