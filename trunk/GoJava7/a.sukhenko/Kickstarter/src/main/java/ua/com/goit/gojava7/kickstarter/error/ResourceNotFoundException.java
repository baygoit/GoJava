package ua.com.goit.gojava7.kickstarter.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = -4198668215878002258L;

}
