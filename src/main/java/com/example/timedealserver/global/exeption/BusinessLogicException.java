package com.example.timedealserver.global.exeption;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {

    private final BasicExceptionType basicExceptionType;

    public BusinessLogicException(BasicExceptionType basicExceptionType) {

        super(basicExceptionType.getMessage());
        this.basicExceptionType = basicExceptionType;
    }
}
