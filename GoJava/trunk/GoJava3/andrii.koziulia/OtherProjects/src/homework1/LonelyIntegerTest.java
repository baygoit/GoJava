package homework1;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LonelyIntegerTest {

  @Test
  public void simpleArray() {
    assertEquals(4, LonelyInteger.findLonelyInteger(new int[]{1, 1, 1, 3, 3, 3, 4}));
  }

  @Test
  public void withBigValues() {
    assertEquals(13, LonelyInteger.findLonelyInteger(new int[]{1, 1, 1, 13, 3, 3, 3, 100, 100, 100}));
  }

  @Test
  public void findingBigValue() {
    assertEquals(1256, LonelyInteger.findLonelyInteger(new int[]{1, 1, 1, 1256, 3, 3, 3, 100, 100, 100}));
  }
}