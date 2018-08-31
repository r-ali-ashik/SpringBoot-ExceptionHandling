package com.aliashik.advice;

import com.aliashik.exception.EmployeeNotFoundException;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    protected ResponseEntity<?> handleApiException(RuntimeException ex, WebRequest request) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("status", HttpStatus.NOT_FOUND.value());
        responseJson.put("message", ex.getMessage());

        return new ResponseEntity<JSONObject>(responseJson, HttpStatus.NOT_FOUND);
    }
}