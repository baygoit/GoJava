package upload.controller;

/**
 * Created by Игорь on 10.12.2015.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import upload.model.FileUpload;

import java.io.File;


public class FileUploadController extends SimpleFormController{

    public FileUploadController(){
        setCommandClass(FileUpload.class);
        setCommandName("fileUploadForm");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
                                    HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        String saveDirectory = "D:\\java\\gitgoit\\GoJava\\trunk\\GoJava6\\ilebedyuk\\workup\\spring_mvc_upload_file\\src\\main\\webapp\\img\\";

        FileUpload file = (FileUpload)command;

        MultipartFile multipartFile = file.getFile();

        String fileName="";

        if(multipartFile!=null){
            fileName = multipartFile.getOriginalFilename();
            //do whatever you want
        }

        multipartFile.transferTo(new File(saveDirectory + fileName));

        return new ModelAndView("FileUploadSuccess","fileName",fileName);
    }
}
