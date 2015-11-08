package collection;

import org.junit.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class GoITMapTest {
    private GoITMap map;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @Before
    public void setUp() {
        map = new GoITMap();
        map.put(new Integer(1), "one");
        map.put(new Integer(11), "one");
        System.out.println("setup");
    }

    @Test
    public void testReturnValue(){
        assertEquals("return value checking", "one", map.get(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        map.remove("somekey");
    }

    @Test
    public void testSize() {
        assertEquals("checking size of map", 2, map.size());
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

}