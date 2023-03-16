package com.example.timedealserver.global.exeption;

import org.springframework.http.HttpStatus;

public interface BasicExceptionType {

    String getErrorCode();

    String getMessage();

    HttpStatus getHttpStatus();

}
