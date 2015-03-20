package ua.goit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    @Test
    public void testSimple() {
        
        Shapefactory triangleFactory = new TriangleFactory();
        Shape triangle = triangleFactory.getShape();
        
        triangle.point1 = 1;
        triangle.point2 = 2;
        triangle.point3 = 3;
        
        Serializer xmlSerializer = SerializerFactory.getSerializer("xml");
        
        String shapeStringXML = xmlSerializer.serialize();
                
        String expectedResult = "<triangle><point1>1</point1><point2>2</point2><point3>3</point3></triangle>";
        
        assertEquals(expectedResult, shapeStringXML);
    }

}
