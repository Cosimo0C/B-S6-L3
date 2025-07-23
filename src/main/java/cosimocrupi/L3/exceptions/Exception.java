package cosimocrupi.L3.exceptions;

import cosimocrupi.L3.payloads.ExceptionPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionPayload handleNotFound(NotFoundException ex){
        return new ExceptionPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(java.lang.Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionPayload handleServerError(java.lang.Exception ex){
        ex.printStackTrace();
        return new ExceptionPayload("Errore generico!", LocalDateTime.now());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionPayload handleBadRequest(BadRequestException ex){
        return new ExceptionPayload(ex.getMessage(), LocalDateTime.now());
    }
}
