package com.project.qrservice.exceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QrServiceException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> imageSizeHandler(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\n \"error\": "+"\""+
                e.getMessage()+"\""+"\n}");
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> imageTypeHandler(NullPointerException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\n \"error\": "+"\""+
                e.getMessage()+"\""+"\n}");
    }

}
