import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by Ыўср on 04.10.2015.
 */
public class ParserTest {
    String filePath1 = "D:\\GoIT\\GoJava\\trunk\\GoJava6\\lhupalo\\EmplParser";
    Parser parser;
    Set<Employee> actual;


    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void testMain() throws Exception {

        actual = parser.employees;
        Set<Employee> expected = new TreeSet();
        Employee employee1 = new Employee(111, "Ivan", 3);
        Employee employee2 = new Employee(112, "Elena", 2);
        Employee employee3 = new Employee(113, "Egor", 3);
        Employee employee4 = new Employee(116, "Igor", 1);
        assertTrue(expected.add(employee1));
        assertTrue(expected.add(employee2));
        assertTrue(expected.add(employee3));
        assertTrue(expected.add(employee4));

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}