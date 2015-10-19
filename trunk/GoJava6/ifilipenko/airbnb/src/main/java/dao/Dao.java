package dao;

import java.io.File;
import java.io.IOException;

public interface Dao {
    public void createAll(File file) throws IOException;
    public void read();
    public void update();
    public void delete();
}
