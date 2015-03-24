package ua.goit.serialization;

/**
 * Class of concrete serialization factory 
 * @author Anton Yarosh
 *
 */
public class ConcreteFactory extends SerializationFactory{
    Serializator serializator;

    /*Return type of serializator*/
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
