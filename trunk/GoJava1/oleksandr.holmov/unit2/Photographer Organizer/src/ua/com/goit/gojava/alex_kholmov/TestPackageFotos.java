package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPackageFotos {
    private PackageFotos  myPackageFotos = new PackageFotos(200, 10, 10);
    
    @Test
    public void testObbjectCreate() {
        assertNotNull(myPackageFotos);
    }

    @Test
    public void testTimeEditingAllFotos() {
        float res = myPackageFotos.timeEditingAllFotos();
        assertEquals("Error", 36, res, 0);
    }

}
