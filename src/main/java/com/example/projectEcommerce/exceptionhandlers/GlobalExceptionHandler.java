package com.example.projectEcommerce.exceptionhandlers;


import ch.qos.logback.core.model.processor.ProcessorException;
import com.example.projectEcommerce.dtos.ExceptionDto;
import com.example.projectEcommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic Exception :(");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)

    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException x){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product with id " + x.id + " not found");
        exceptionDto.setResolution("Please check the id and try again");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
