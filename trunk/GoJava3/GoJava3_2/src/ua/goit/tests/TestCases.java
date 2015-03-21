package ua.goit.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import ua.goit.managers.*;
import ua.goit.model.*;

public class TestCases {

    public Triangle newTestTriangle(){
        TriangleFactory triangleFactory = new TriangleFactory();
        Triangle triangle = triangleFactory.getShapeContainer();
        
        triangle.point1 = new Point(1,1);
        triangle.point2 = new Point(2,2);
        triangle.point3 = new Point(3,3);
        
        return triangle;
    }
    
    public GroupShapes newTestGroup(){
        GroupShapesFactory groupFactory = new GroupShapesFactory();
        GroupShapes group = groupFactory.getShapeContainer();
        
        TriangleFactory triangleFactory = new TriangleFactory();
        Triangle triangle = triangleFactory.getShapeContainer();
        
        triangle.point1 = new Point(1,1);
        triangle.point2 = new Point(2,2);
        triangle.point3 = new Point(3,3);
        
        group.add(triangle);
        
        return group;
    }

    @Test
    public void testSimpleXML() {
        
        Serializer xmlSerializer = SerializerFactory.getSerializer("xml");
        
        Triangle triangle = newTestTriangle();
        String shapeStringXML = xmlSerializer.serialize(triangle);
                
        String expectedResult = "<triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>2</y></point2><point3><x>3</x><y>3</y></point3></triangle>";
        
        assertEquals(expectedResult, shapeStringXML);
    }

    @Test
    public void testSimpleJSON() {
        
        Serializer jsonSerializer = SerializerFactory.getSerializer("json");
        
        Triangle triangle = newTestTriangle();
        String shapeStringJSON = jsonSerializer.serialize(triangle);
                
        String expectedResult = "{point1:{x=1,y=1},point2:{x=2,y=2},point3:{x=3,y=3}}";
        
        assertEquals(expectedResult, shapeStringJSON);
    }
    @Test
    public void testGroupXML() {
        
        GroupShapes groupShapes = newTestGroup();

        Serializer xmlSerializer = SerializerFactory.getSerializer("xml");
        String shapeStringXML = xmlSerializer.serialize(groupShapes);
                
        String expectedResult = "<group><triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>2</y></point2><point3><x>3</x><y>3</y></point3></triangle></group>";
        
        assertEquals(expectedResult, shapeStringXML);
    }

    @Test
    public void testGroupJSON() {
        
        GroupShapes groupShapes = newTestGroup();

        Serializer jsonSerializer = SerializerFactory.getSerializer("json");
        String shapeStringJSON = jsonSerializer.serialize(groupShapes);
                
        String expectedResult = "{triangle:{point1:{x=1,y=1},point2:{x=2,y=2},point3:{x=3,y=3}}}";
        
        assertEquals(expectedResult, shapeStringJSON);
    }
}
