package ua.goit.main;
import java.util.ArrayList;
import java.util.Iterator;

import ua.goit.serialization.*;
import ua.goit.graphElements.*;

public class Client {

    public static void main(String[] args) {
	SerializationFactory factory = null;
	Serializator xmlSerialization = null;
	Serializator jsonSerialization = null;
	factory = new ConcreteFactory();
	xmlSerialization = factory.getSerializationFor(SerializationType.XML);
	jsonSerialization = factory.getSerializationFor(SerializationType.JSON);

	    
	
	
    }
}
