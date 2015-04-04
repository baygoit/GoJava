package ua.goit.serialization;

/**
 * Class of concrete serialization factory 
 */
public class ConcreteFactory extends SerializationFactory{

    /** Return type of serializator*/
    @Override
    public Serializator getSerializationFor(SerializationType type) {
	switch (type) {
	case  XML: 
	    return new XMLSerializator();
	case JSON:
	    return new JSONSerializator();	  
	}
	return null;
    }   
}
