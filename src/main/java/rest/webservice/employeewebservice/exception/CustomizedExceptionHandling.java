package rest.webservice.employeewebservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // Common controller across the application. Act like interceptor for an exception where method is annotated with @RequestMapping, @GETMapping
@RestController // Why because it provides the response
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exResp = new ExceptionResponse(request.getDescription(false), ex.getMessage(), new Date());
        return new ResponseEntity<ExceptionResponse>(exResp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
        ExceptionResponse exResp = new ExceptionResponse(request.getDescription(false), ex.getMessage(), new Date());
        return new ResponseEntity<ExceptionResponse>(exResp, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exResp = new ExceptionResponse(ex.getBindingResult().toString(), "Validation Failed", new Date());
        return new ResponseEntity<Object>(exResp, HttpStatus.BAD_REQUEST);
    }
}