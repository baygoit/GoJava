package ua.goit.serialization;

public abstract class SerializationFactory {
    
    abstract public Serializator getSerializationFor(SerializationType type);

}