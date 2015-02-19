/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * @author SASH
 *
 */
public class TestReserve {
    private Reserve reserve = new Reserve();
    /**
     * Test method for {@link ua.com.goit.gojava.alex_kholmov.Reserve#setReserveDate(java.lang.String)}.
     */
    @Test
    public void testSetReserveDate() {
        reserve.setReserveDate("12.04.2015 15:45");
        String res = reserve.getReserveDate();
        assertEquals("error in date", "12.04.2015 15:45", res);
    }

}
