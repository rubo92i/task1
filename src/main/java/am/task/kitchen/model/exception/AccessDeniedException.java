package am.task.kitchen.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }


}

