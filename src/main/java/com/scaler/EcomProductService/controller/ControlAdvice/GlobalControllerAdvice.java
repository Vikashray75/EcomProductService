package com.scaler.EcomProductService.controller.ControlAdvice;

import com.scaler.EcomProductService.Exception.ProductNotFoundException;
import com.scaler.EcomProductService.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
//    @ExceptionHandler(value = NullPointerException.class)
//    public ResponseEntity<String> handleNullPointerException(Exception ex)
//    {
//        String exceptionResponse="error:Something went wrong "+ HttpStatus.INTERNAL_SERVER_ERROR;
//            return ResponseEntity.ok(exceptionResponse);
//    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception ex)
    {
        ErrorResponseDTO errorResponse=new ErrorResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setMessageCode(404);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
