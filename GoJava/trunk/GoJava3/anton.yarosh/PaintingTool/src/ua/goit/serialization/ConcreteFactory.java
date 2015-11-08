package ua.goit.serialization;

public class ConcreteFactory extends SerializationFactory{
    Serializator serializator;

    @Override
    public Serializator getSerializationFor(SerializationType type) {
	switch (type) {
	case  XML: 
	    serializator = new XMLSerializator();
	    break;
	case JSON:
	    serializator = new JSONSerializator();
	    break;
	}
	return serializator;
    }   
}
