package hw3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class ParserTest {

    Parser parser;
    Queue<Employee> actual;

    @Before
    public void init() {
        parser = new Parser();
    }

    @Test
    public void verifyThatEmployeeListIsSortedByManagerId() throws IOException {
        actual = parser.parseFileTextToSortedEmployeeList("/parserFile1");

        Queue<Employee> expected = new PriorityQueue<>();
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

    @Test
    public void verifyDefaultValuesReturnForEmployeeWhenIdOrNameOrManagerIsEmpty() throws IOException {
        actual = parser.parseFileTextToSortedEmployeeList("/parserFile2");

        Queue<Employee> expected = new PriorityQueue<>();
        Employee employee1 = new Employee(3, "Name1", 4);
        Employee employee2 = new Employee();
        expected.add(employee1);
        expected.add(employee2);

        Assert.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    public void verifyThatEmployeeCannotBeEmpty() throws IOException {
        actual = parser.parseFileTextToSortedEmployeeList("/parserFile3");

        Queue<Employee> expected = new PriorityQueue<>();
        Employee employee1 = new Employee(0, null, 0);
        expected.add(employee1);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void sortQueue(){
        Set<Employee> expected = new HashSet<>();
        Employee employee1 = new Employee(3, "Name4", 1);
        Employee employee2 = new Employee(1, "Name3", 4);
        Employee employee3 = new Employee(2, "Name2", 2);
        Employee employee4 = new Employee(3, "Name1", 4);
        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee3);
        expected.add(employee4);

        for (Employee employee : expected) {
            System.out.println(employee);
        }
    }



}
