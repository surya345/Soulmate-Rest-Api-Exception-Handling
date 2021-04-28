package com.stackroute.Soulmaterestservice.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Value(value="${data.exception.message1}")
    private String message1;

    @Value(value="${data.exception.message1}")
    private String message2;

    @ExceptionHandler(value=UserAlreadyExistsException.class)
    public ResponseEntity<String> userAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException)
    {
        return new ResponseEntity<String>(message1, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>("Database connectivity is lost", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value=RecordNotFoundException.class)
    public ResponseEntity<String> recordNotFoundException(RecordNotFoundException recordNotFoundException)
    {
      return new ResponseEntity<String>(message2,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value={NullPointerException.class,ArrayIndexOutOfBoundsException.class, IOException.class})
    public ModelAndView handleException(NullPointerException exception){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message",exception.getMessage());
        return modelAndView;
    }

}
