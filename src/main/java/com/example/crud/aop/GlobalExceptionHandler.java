package com.example.crud.aop;

import com.example.crud.dto.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorEntity> handleException(Exception e) {
        // 处理异常逻辑
        return new ResponseEntity<ErrorEntity>(new ErrorEntity(e.getLocalizedMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
