package ua.goit.serialization;

/**
 * Abstract class for serializator creating factory
 * @author Anton Yarosh
 *
 */
public abstract class SerializationFactory {
    
    abstract public Serializator getSerializationFor(SerializationType type);
}