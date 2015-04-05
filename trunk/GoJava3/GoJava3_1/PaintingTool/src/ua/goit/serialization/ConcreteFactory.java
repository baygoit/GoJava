package ua.goit.serialization;

/**
 * Class of concrete serialization factory 
 */
public class ConcreteFactory extends SerializationFactory{

    /**
     * Return type of serializer depends on type - XML or JSON
     * @param type serializer type 
     * @return instance of serializer class 
     */
    @Override
    public Serializer getSerializationFor(SerializationType type) {
	switch (type) {
	case  XML: 
	    return new XMLSerializator();
	case JSON:
	    return new JSONSerializator();	  
	}
	return null;
    }   
}
