package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class SimplePOTest {
    @Test
    public void testPO() {
        ParameterObject po = new ParameterObject();
        ActionResult result = new ActionResult(false, null);
        result.addChange(null);
        assertNull(result.getNextChange());
        result.addChange(po);
        assertNotNull(result.getNextChange());
    }
}
