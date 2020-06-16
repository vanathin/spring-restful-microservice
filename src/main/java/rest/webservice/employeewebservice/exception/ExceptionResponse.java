package rest.webservice.employeewebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private String details;
    private String message;
    private Date timeStamp;


}
