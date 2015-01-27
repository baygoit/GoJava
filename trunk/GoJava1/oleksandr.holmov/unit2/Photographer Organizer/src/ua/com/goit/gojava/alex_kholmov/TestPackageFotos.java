package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPackageFotos {
    private PackageFotos  myPackageFotos = new PackageFotos();
    
    @Test
    public void testObbjectCreate() {
        assertNotNull(myPackageFotos);
    }

    @Test
    public void testTimeEditingAllFotos() {
        myPackageFotos.setAmountFotos(45);
        myPackageFotos.setTimeEditingFoto(20);
        myPackageFotos.setTimeReserve(10);
        float res = myPackageFotos.timeEditingAllFotos();
        assertEquals(990.0, res, 0);
    }

}
