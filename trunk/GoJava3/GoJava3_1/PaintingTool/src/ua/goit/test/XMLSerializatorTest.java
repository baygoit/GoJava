package ua.goit.test;

import ua.goit.graphElements.Group;
import ua.goit.graphElements.GroupImpl;
import ua.goit.graphElements.Point;
import ua.goit.graphElements.PointImpl;
import ua.goit.serialization.ConcreteFactory;
import ua.goit.serialization.SerializationType;
import ua.goit.shapes.Circle;
import ua.goit.shapes.Triangle;

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

    @org.junit.Test
    public void testSerializeOneElement() throws Exception {
        triangle1.addPoint(point1);
        triangle1.addPoint(point2);

        String exceptedResult = "<Triangle>triangle1<Points><Point>(1, 2)</Point><Point>(2, 1)</Point></Points></Triangle>";
        String actualResult = factory.getSerializationFor(SerializationType.XML).serialize(triangle1).toString();
        assertEquals(exceptedResult, actualResult);
    }

    @org.junit.Test
    public void testSerializeOneGroup() throws Exception {
        triangle1.addPoint(point1);
        triangle2.addPoint(point2);
        group1.setElement(triangle1);
        group1.setElement(triangle2);

        String exceptedResult = "<Group>group1<Triangle>triangle1<Points><Point>(1, 2)</Point></Points></Triangle>" +
                "<Triangle>triangle2<Points><Point>(2, 1)</Point></Points></Triangle></Group>";
        String actualResult = factory.getSerializationFor(SerializationType.XML).serialize(group1).toString();
        assertEquals(exceptedResult, actualResult);
    }

    @org.junit.Test
    public void testSerializeInnerGroup() throws Exception {
        triangle1.addPoint(point1);
        triangle2.addPoint(point2);
        group1.setElement(triangle1);
        group1.setElement(triangle2);
        group2.setGroup(group1);

        String exceptedResult = "<Group>group2<Group>group1<Triangle>triangle1<Points><Point>(1, 2)</Point></Points></Triangle>" +
                "<Triangle>triangle2<Points><Point>(2, 1)</Point></Points></Triangle></Group></Group>";
        String actualResult = factory.getSerializationFor(SerializationType.XML).serialize(group2).toString();
        assertEquals(exceptedResult, actualResult);
    }

    @org.junit.Test
    public void testSerializeFewInnerGroup() throws Exception {
        triangle1.addPoint(point1);
        triangle2.addPoint(point2);
        group1.setElement(triangle1);
        group1.setElement(triangle2);
        group2.setGroup(group1);
        group2.setElement(circle1);
        group3.setElement(triangle1);
        group3.setGroup(group2);
        group3.setElement(circle2);

        String exceptedResult = "<Group>group3<Group>group2<Group>group1<Triangle>triangle1<Points><Point>(1, 2)</Point></Points>" +
                "</Triangle><Triangle>triangle2<Points><Point>(2, 1)</Point></Points></Triangle></Group>" +
                "<Circle>circle1<Points></Points></Circle></Group><Triangle>triangle1<Points><Point>(1, 2)</Point></Points></Triangle>" +
                "<Circle>circle2<Points></Points></Circle></Group>";
        String actualResult = factory.getSerializationFor(SerializationType.XML).serialize(group3).toString();
        assertEquals(exceptedResult, actualResult);
    }


}