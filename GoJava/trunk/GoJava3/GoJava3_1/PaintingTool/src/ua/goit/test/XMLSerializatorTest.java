package ua.goit.test;

import org.junit.Before;
import org.junit.Test;
import ua.goit.graphElements.Group;
import ua.goit.graphElements.GroupImpl;
import ua.goit.graphElements.Point;
import ua.goit.graphElements.PointImpl;
import ua.goit.serialization.ConcreteFactory;
import ua.goit.serialization.SerializationType;
import ua.goit.shapes.Circle;
import ua.goit.shapes.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class XMLSerializatorTest {
    private Point point1 = new PointImpl(1,2);
    private Point point2 = new PointImpl(2,1);
    private Triangle triangle1 = new Triangle("triangle1");
    private Triangle triangle2 = new Triangle("triangle2");
    private Triangle triangle3 = new Triangle("triangle3");
    private Circle circle1 = new Circle("circle1");
    private Circle circle2 = new Circle("circle2");
    private Group group1 = new GroupImpl("group1");
    private Group group2 = new GroupImpl("group2");
    private Group group3 = new GroupImpl("group3");
    private ConcreteFactory factory = new ConcreteFactory();
    private final Map<String, String> initActualResultForMethod = new HashMap<String, String>();
    private final Map<String, String> initExpectedResultForMethod = new HashMap<String, String>();
    private final static String TEST_PATH = "C:\\Users\\roznalex\\IdeaProjects\\GoJava3\\GoJava3_1\\PaintingTool\\src\\ua\\goit\\test\\fixtures\\";

    public static String readFile(File file){
        String result = "";
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                result += in.nextLine();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Before
    public void  init() {
        triangle1.addPoint(point1);
        triangle2.addPoint(point2);
        group1.setElement(triangle1);
        group1.setElement(triangle2);
        group2.setGroup(group1);
        group2.setElement(circle1);
        group3.setElement(triangle1);
        group3.setGroup(group2);
        group3.setElement(circle2);

        initActualResultForMethod.put("testSerializeOneElement", factory.getSerializationFor(SerializationType.XML).serialize(triangle1).toString());
        initActualResultForMethod.put("testSerializeOneGroup", factory.getSerializationFor(SerializationType.XML).serialize(group1).toString());
        initActualResultForMethod.put("testSerializeInnerGroup", factory.getSerializationFor(SerializationType.XML).serialize(group2).toString());
        initActualResultForMethod.put("testSerializeFewInnerGroup", factory.getSerializationFor(SerializationType.XML).serialize(group3).toString());

        initExpectedResultForMethod.put("testSerializeOneElement", readFile(new File(TEST_PATH + "testSerializeOneElement")));
        initExpectedResultForMethod.put("testSerializeOneGroup", readFile(new File(TEST_PATH + "testSerializeOneGroup")));
        initExpectedResultForMethod.put("testSerializeInnerGroup", readFile(new File(TEST_PATH + "testSerializeInnerGroup")));
        initExpectedResultForMethod.put("testSerializeFewInnerGroup", readFile(new File(TEST_PATH + "testSerializeFewInnerGroup")));

    }


    @Test
    public void testSerializeOneElement() throws Exception {
        String exceptedResult = initExpectedResultForMethod.get("testSerializeOneElement");
        String actualResult = initActualResultForMethod.get("testSerializeOneElement");
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void testSerializeOneGroup() throws Exception {
        String exceptedResult = initExpectedResultForMethod.get("testSerializeOneGroup");
        String actualResult = initActualResultForMethod.get("testSerializeOneGroup");
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void testSerializeInnerGroup() throws Exception {
        String exceptedResult = initExpectedResultForMethod.get("testSerializeInnerGroup");
        String actualResult = initActualResultForMethod.get("testSerializeInnerGroup");
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void testSerializeFewInnerGroup() throws Exception {
        String exceptedResult = initExpectedResultForMethod.get("testSerializeFewInnerGroup");
        String actualResult = initActualResultForMethod.get("testSerializeFewInnerGroup");
        assertEquals(exceptedResult, actualResult);
    }
}