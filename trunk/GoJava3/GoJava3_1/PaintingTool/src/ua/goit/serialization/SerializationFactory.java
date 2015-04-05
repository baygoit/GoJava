package ua.goit.serialization;

/**
 * Abstract class for serializer creating factory
 */
public abstract class SerializationFactory {
    abstract public Serializer getSerializationFor(SerializationType type);
}