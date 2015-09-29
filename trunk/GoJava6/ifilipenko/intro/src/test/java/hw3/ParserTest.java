package hw3;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.PriorityQueue;

public class ParserTest {

    String filePath = "C:\\Users\\ifilipenko\\Dropbox\\GitHub\\GoJava\\trunk\\GoJava6\\ifilipenko\\intro\\test";

    @Test
    public void verifyThatEmployeeListIsSortedByManagerId() throws IOException {
        Parser parser = new Parser();
        PriorityQueue<Employee> actual = parser.parseFileTextToSortedEmployeeList(filePath);

        PriorityQueue<Employee> expected = new PriorityQueue<>();
        Employee employee1 = new Employee(3, "Name4", 1);
        Employee employee2 = new Employee(1, "Name3", 2);
        Employee employee3 = new Employee(2, "Name2", 3);
        Employee employee4 = new Employee(3, "Name1", 4);

        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee3);
        expected.add(employee4);

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
