package rest.webservice.employeewebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Searched ID Not Found")
public class UserNotFoundException extends RuntimeException {

    String message = "";
    public UserNotFoundException(String message){
        super(message);
        this.message = message;
    }
    //To avoid trace message
    //If you don't need the stack trace you can suppress the stack trace by overriding fillInStackTrace in your exception class.
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
