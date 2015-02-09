package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;

public class SimplePOTest {
    @Test
    public void testPO() {
        ActionParameters po = new ActionParameters();
        ActionResult result = new ActionResult(false, null);
        result.addChange(null);
        assertNull(result.getNextChange());
        result.addChange(po);
        assertNotNull(result.getNextChange());
    }
}
