package dao;

import java.io.IOException;

public interface Dao {
    public void createAll() throws IOException;
    public void read();
    public void update();
    public void delete();
}
