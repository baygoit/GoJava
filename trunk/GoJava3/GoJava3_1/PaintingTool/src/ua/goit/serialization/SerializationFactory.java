package ua.goit.serialization;

/**
 * Abstract class for serializer creating factory
 */
public abstract class SerializationFactory {
    public abstract Serializer getSerializationFor(SerializationType type);
}