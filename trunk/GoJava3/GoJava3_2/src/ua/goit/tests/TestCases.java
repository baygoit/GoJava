package ua.goit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    @Test
    public void testSimple() {
        
        Shapefactory triangleFactory = new triangleFactory();
        Shape triangle = triangleFactory.getShape();
        
        //Serializator xmlSerializator = SerializatorFactory.get
        
        fail("Not yet implemented");
    }

}
