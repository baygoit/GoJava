package upload.model;

/**
 * Created by Игорь on 10.12.2015.
 */
import org.springframework.web.multipart.MultipartFile;

public class FileUpload{

    MultipartFile file;
    //getter and setter methods

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
