package am.task.kitchen.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotAcceptableException extends Exception {

    public NotAcceptableException(String message) {
        super(message);
    }


}

