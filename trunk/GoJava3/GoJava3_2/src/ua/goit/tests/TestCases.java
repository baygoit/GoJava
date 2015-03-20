package ua.goit.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import ua.goit.managers.*;
import ua.goit.model.*;

public class TestCases {

    @Test
    public void testSimple() {
        
        TriangleFactory triangleFactory = new TriangleFactory();
        Triangle triangle = triangleFactory.getShape();
        
        triangle.point1 = new Point(1,1);
        triangle.point2 = new Point(2,2);
        triangle.point3 = new Point(3,3);
        
        Serializer xmlSerializer = SerializerFactory.getSerializer("xml");
        
        String shapeStringXML = xmlSerializer.serialize();
                
        String expectedResult = "<triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>2</y></point2><point3><x>3</x><y>3</y></point3></triangle>";
        
        assertEquals(expectedResult, shapeStringXML);
    }

}
