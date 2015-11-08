package dao.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileAccess {
    private String path;

    public FileAccess(String path) {
        this.path = path;
    }

    public List<String> readAllLines() throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public void writeAllLines(String data) throws IOException {
        Files.write(Paths.get(path), data.getBytes());
    }
}
