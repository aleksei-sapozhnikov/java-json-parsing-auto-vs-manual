package com.github.vermucht.json_parsing_auto_vs_manual;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** Handles parsing exceptions and returns their stacktrace as answer */
@ControllerAdvice
public class HandlerException {
    @ExceptionHandler({ RuntimeException.class, HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleHttpMessageNotReadable(Exception e) {
        return new ResponseEntity<>(getStackTraceAsString(e), HttpStatus.BAD_REQUEST);
    }

    private static String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
