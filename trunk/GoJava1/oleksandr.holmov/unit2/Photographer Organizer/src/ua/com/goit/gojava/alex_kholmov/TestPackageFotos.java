package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPackageFotos {
    private PackageFotos  myPackageFotos = new PackageFotos(30, 15, 0);
    
    @Test
    public void testObbjectCreate() {
        assertNotNull(myPackageFotos);
    }

    @Test
    public void testTimeEditingAllFotos() {
        float res = myPackageFotos.timeEditingAllFotos();
        assertEquals(7.0, res, 0);
    }

}
