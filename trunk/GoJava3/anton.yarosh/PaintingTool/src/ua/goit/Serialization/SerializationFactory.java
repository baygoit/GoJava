package ua.goit.Serialization;

public abstract class SerializationFactory {
    
    abstract public Serializator getSerializationFor(SerializationType type);

}