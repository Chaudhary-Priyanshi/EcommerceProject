package com.example.productservice.controllerAdvice;

import com.example.productservice.dto.ErrorDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> ArithmeticExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("ArithmeticException");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDto> ArrayIndexOutOfBoundsExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("ArrayIndexOutOfBoundsException");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ErrorDto NullPointerExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("NullPointerException");
        //return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        return errorDto;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto ProductNotFoundExceptionHandler(ProductNotFoundException productNotFoundException){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(productNotFoundException.getMessage());
        return errorDto;
    }
}
