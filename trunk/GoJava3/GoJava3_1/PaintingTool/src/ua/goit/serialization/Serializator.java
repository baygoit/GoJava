package ua.goit.serialization;
import java.io.File;

import ua.goit.graphElements.*;

public abstract class Serializator {

    public abstract StringBuffer serialize(IGroup element);
    public abstract StringBuffer serialize(IElement element);
    public abstract void saveToFile(StringBuffer source, File file);
}
